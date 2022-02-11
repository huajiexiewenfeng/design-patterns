package com.csdn.design.patterns.thinking.principle.solid.transporter;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import sun.net.www.http.HttpClient;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 13:43
 */
public class Demo {

  public static void main(String[] args) throws IOException {
    Demo demo = new Demo();
    URL url = new URL("http", "127.0.0.1", 8080, "");
    HttpClient httpClient = new HttpClient(url, "127.0.0.1", 8080);
    Transporter transporter = new SecurityTransporter(httpClient, "test", "test-token");
    demo.test(transporter);
  }

  public void test(Transporter transporter) {
    HttpRequest request = new HttpRequest() {
      @Override
      public String getMethodValue() {
        return null;
      }

      @Override
      public URI getURI() {
        return null;
      }

      @Override
      public HttpHeaders getHeaders() {
        return null;
      }
    };
    transporter.sendRequest(request);
  }
}
