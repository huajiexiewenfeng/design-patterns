package com.csdn.design.patterns.thinking.oop.auth;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 15:15
 */
public class DefaultApiAuthenticator implements ApiAuthenticator {

  private CredentialStorage credentialStorage;

  public DefaultApiAuthenticator() {
  }

  public DefaultApiAuthenticator(
      CredentialStorage credentialStorage) {
    this.credentialStorage = credentialStorage;
  }

  @Override
  public void auth(String url) {
    ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
    auth(apiRequest);
  }

  @Override
  public void auth(ApiRequest apiRequest) {
    String appId = apiRequest.getAppId();
    String token = apiRequest.getToken();
    long timestamp = apiRequest.getTimestamp();
    String baseUrl = apiRequest.getBaseUrl();
    AuthToken clientAuthToken = new AuthToken(token, timestamp);

    if (clientAuthToken.isExpired()) {
      throw new RuntimeException("Token is expired.");
    }

    String password = credentialStorage.getPasswordByAppId(appId);
    AuthToken serverAuthToken = AuthToken.generate(baseUrl, appId, password, timestamp);
    if (serverAuthToken != null && !serverAuthToken.match(clientAuthToken)) {
      throw new RuntimeException("Token verification failed.");
    }
  }
}
