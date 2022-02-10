package com.csdn.design.patterns.thinking.oop.auth;

import java.util.Map;

/**
 * 功能点
 * <p>1.把 URL、AppID、密码、时间戳拼接为一个字符串；<p/>
 * <p>2.对字符串通过加密算法加密生成 token；<p/>
 * <p>3.根据时间戳判断 token 是否过期失效；<p/>
 * <p>4.验证两个 token 是否匹配。<p/>
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/10 14:35
 */
public class AuthToken {

  /**
   * 默认过期时间 1分钟
   */
  private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
  private String token;
  private long createTime;
  private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

  public AuthToken(String token, long createTime) {
    this.token = token;
    this.createTime = createTime;
  }

  public AuthToken(String token, long createTime, long expiredTimeInterval) {
    this.token = token;
    this.createTime = createTime;
    this.expiredTimeInterval = expiredTimeInterval;
  }

  public static AuthToken create(String baseUrl, long createTime, Map<String, String> params) {
    return null;
  }

  public static AuthToken generate(String baseUrl, String appId, String password, long timestamp) {
    return null;
  }

  public String getToken() {
    return token;
  }

  public boolean isExpired() {
    return false;
  }

  public boolean match(AuthToken authToken) {
    return false;
  }
}
