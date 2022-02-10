package com.csdn.design.patterns.thinking.oop.auth;

/**
 * <p>1.将 token、AppID、时间戳拼接到 URL 中，形成新的 URL；<p/>
 * <p>2.解析 URL，得到 token、AppID、时间戳等信息。</p>
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/10 14:35
 */
public class ApiRequest {

  private String baseUrl;
  private String token;
  private String appId;
  private long timestamp;

  public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
    this.baseUrl = baseUrl;
    this.token = token;
    this.appId = appId;
    this.timestamp = timestamp;
  }

  public static ApiRequest createFromFullUrl(String url) {
    return null;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public String getToken() {
    return token;
  }

  public String getAppId() {
    return appId;
  }

  public long getTimestamp() {
    return timestamp;
  }
}
