package com.csdn.design.patterns.thinking.principle.solid.alert;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:13
 */
public class AlertRule {

  private long maxTps = 10;

  private long maxTimeoutTps = 5;

  private long maxErrorCount = 2;

  public AlertRule getMatchRule(String api) {
    return this;
  }

  public long getMaxTps() {
    return maxTps;
  }

  public long getMaxErrorCount() {
    return maxErrorCount;
  }

  public long getMaxTimeoutTps() {
    return maxTimeoutTps;
  }
}
