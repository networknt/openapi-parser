# openapi-parser

A light-weight, fast OpenAPI 3.0 parser and validator with minimum third party dependencies.

[Stack Overflow](https://stackoverflow.com/questions/tagged/light-4j) |
[Google Group](https://groups.google.com/forum/#!forum/light-4j) |
[Gitter Chat](https://gitter.im/networknt/light-rest-4j) |
[Subreddit](https://www.reddit.com/r/lightapi/) |
[Youtube Channel](https://www.youtube.com/channel/UCHCRMWJVXw8iB7zKxF55Byw) |
[Documentation](https://doc.networknt.com/library/openapi-parser/) |
[Contribution Guide](https://doc.networknt.com/contribute/) |

It is based on the generated code from [KaiZen OpenAPI Parser](https://github.com/RepreZen/KaiZen-OpenApi-Parser) without
dependency on javaparser-core, guava, commons-cli, commons-io, javax.mail and guice.

### Base path compatibility

OpenAPI path keys are relative to the first server URL. With server `/v1`, use
path key `/pets` to expose `/v1/pets` (endpoint `/v1/pets@get`). Earlier versions
also stripped the server prefix from specification keys, allowing a redundant
key `/v1/pets` to serve that same URL. That rewriting is removed: a key
`/v1/pets` now describes `/v1/v1/pets` with endpoint `/v1/v1/pets@get`.

Before upgrading, remove redundant server prefixes from path keys if the service
must keep its current URLs and endpoint identifiers. Review endpoint-based Lambda
mappings, security configuration, metrics and dashboards when intentionally
retaining repeated prefixes. A leading segment equal to the server prefix can
also be intentional, so the parser does not guess which form was intended.
Unprefixed request paths remain supported for compatibility.

Request-prefix strategies use a Caffeine cache with a maximum size of 64 after
maintenance; concurrent activity can temporarily exceed that size. Literal base
paths use string comparisons, while regex base paths use cached patterns.

### Jackson 3 migration

This development line uses Jackson 3.2.3 and the migrated json-overlay API.
Public parser and model constructors accepting `JsonNode` now use
`tools.jackson.databind` types. This is a source and binary incompatible change;
downstream users, including light-rest-4j, light-gateway, http-sidecar and
light-codegen, must migrate together. Project versions remain unchanged during
implementation; a next-major version and release decision is required before
publication.

YAML follows the Jackson 3 SnakeYAML Engine resolver. The spellings
`yes/no/on/off`, `True/TRUE/False/FALSE`, `Null/NULL`, `012`, `0b11`, `0x1F`,
`1_000` and `~` now produce strings. Use lowercase `true`, `false`, `null` and
ordinary decimal numbers without leading zeros for typed values. For example,
`required: True` and `deprecated: FALSE` yield null Boolean overlay values.
The validator reports type errors for parameter `required` and `deprecated`,
request-body `required`, and schema Boolean fields. Path parameters additionally
require `required: true`. Numeric keywords using noncanonical spellings report
type errors; normalize specifications before upgrading.
Enum and example values also retain these spellings as strings. Duplicate keys
remain last-wins. The parser reads only the first YAML document and ignores
subsequent documents.

Malformed input is wrapped in `OpenApiParserException`, including Jackson 3's
unchecked `JacksonException`. Empty and comment-only specifications are rejected
with `Spec document is empty`. File I/O error handling remains in place.

### License

The OpenAPI Parser is provided under the Eclipse Public License 1.0 following the parent [KaiZen OpenAPI Parser](https://github.com/RepreZen/KaiZen-OpenApi-Parser)

### Building the migration before release

The unchanged `com.networknt:json-overlay:2.4.2-SNAPSHOT` coordinate must resolve
to the Jackson 3 implementation merged in json-overlay PR #28. An older cached
or remotely deployed Jackson 2 snapshot is incompatible. For a clean local
build, use an isolated Maven repository, build/install json-overlay's migrated
master first, then build/install openapi-parser with that same Maven repository.
For consumers of remote snapshots, deploy the migrated json-overlay snapshot
before openapi-parser, then migrate downstream consumers. Neither repository
currently defines a GitHub Actions workflow; the reported results are local
validation, not remote CI. This PR does not deploy either artifact.
