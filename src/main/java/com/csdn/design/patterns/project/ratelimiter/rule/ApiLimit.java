package com.csdn.design.patterns.project.ratelimiter.rule;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 16:21
 */
public class ApiLimit {

  private static final int DEFAULT_TIME_UNIT_IN_SECOND = 1;
  private String api;
  private int limit;
  private int unit = DEFAULT_TIME_UNIT_IN_SECOND;

  public ApiLimit() {
  }

  public ApiLimit(String api, int limit) {
    this(api, limit, DEFAULT_TIME_UNIT_IN_SECOND);
  }

  public ApiLimit(String api, int limit, int unit) {
    this.api = api;
    this.limit = limit;
    this.unit = unit;
  }

  public String getApi() {
    return api;
  }

  public void setApi(String api) {
    this.api = api;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getUnit() {
    return unit;
  }

  public void setUnit(int unit) {
    this.unit = unit;
  }
}
