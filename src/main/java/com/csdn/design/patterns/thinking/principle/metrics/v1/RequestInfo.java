package com.csdn.design.patterns.thinking.principle.metrics.v1;

import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 11:15
 */
@Data
public class RequestInfo {

  private String apiName;
  private double responseTime;
  private long timestamp;

  public RequestInfo(String apiName, double responseTime, long timestamp) {
    this.apiName = apiName;
    this.responseTime = responseTime;
    this.timestamp = timestamp;
  }
}
