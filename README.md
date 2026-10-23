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

### License

The OpenAPI Parser is provided under the Eclipse Public License 1.0 following the parent [KaiZen OpenAPI Parser](https://github.com/RepreZen/KaiZen-OpenApi-Parser)
