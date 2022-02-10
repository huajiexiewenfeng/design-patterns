package com.csdn.design.patterns.thinking.oop.auth;

/**
 * 从存储中取出 AppID 和对应的密码
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/10 14:36
 */
public interface CredentialStorage {

  String getPasswordByAppId(String appId);

}
