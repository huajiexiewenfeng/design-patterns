package com.csdn.design.patterns.thinking.oop.auth;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 15:12
 */
public interface ApiAuthenticator {

  void auth(String url);

  void auth(ApiRequest apiRequest);

}
