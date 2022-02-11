package com.csdn.design.patterns.thinking.principle.solid.transporter;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import sun.net.www.http.HttpClient;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 13:37
 */
public class Transporter {
 private HttpClient httpClient;

  public Transporter(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public HttpResponse sendRequest(HttpRequest request){
    return null;
  }
}
