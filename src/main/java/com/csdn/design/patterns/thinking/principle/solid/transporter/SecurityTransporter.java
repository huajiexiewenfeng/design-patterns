package com.csdn.design.patterns.thinking.principle.solid.transporter;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.util.ObjectUtils;
import sun.net.www.http.HttpClient;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 13:40
 */
public class SecurityTransporter extends Transporter {

  private String appId;
  private String appToken;

  public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
    super(httpClient);
    this.appId = appId;
    this.appToken = appToken;
  }

  @Override
  public HttpResponse sendRequest(HttpRequest request) {
    if (!ObjectUtils.isEmpty(appId) && !ObjectUtils.isEmpty(appToken)) {
      HttpHeaders headers = request.getHeaders();
      headers.add("app-id", appId);
      headers.add("app-token", appToken);
    }
    return super.sendRequest(request);
  }
}
