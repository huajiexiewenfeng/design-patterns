package com.csdn.design.patterns.thinking.principle.solid.alert.v3;

import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:28
 */
@Data
public class ApiStatInfo {
  private String api;
  private long requestCount;
  private long errorCount;
  private long durationOfSeconds;
  private long timeoutCount;
}
