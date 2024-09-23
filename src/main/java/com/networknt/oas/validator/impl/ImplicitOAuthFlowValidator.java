package com.networknt.oas.validator.impl;

import static com.networknt.oas.model.impl.OAuthFlowImpl.F_authorizationUrl;
import static com.networknt.oas.model.impl.OAuthFlowImpl.F_refreshUrl;
import static com.networknt.oas.model.impl.OAuthFlowImpl.F_scopes;

import com.networknt.oas.model.OAuthFlow;
import com.networknt.oas.validator.ObjectValidatorBase;


public class ImplicitOAuthFlowValidator extends ObjectValidatorBase<OAuthFlow> {

  @Override
  public void runObjectValidations() {
    OAuthFlow oauthFlow = (OAuthFlow) value.getOverlay();
    validateUrlField(F_authorizationUrl, true, true, false);
    validateUrlField(F_refreshUrl, false, true, false);
    validateMapField(F_scopes, true, false, String.class, null);
    validateExtensions(oauthFlow.getExtensions());
  }

}