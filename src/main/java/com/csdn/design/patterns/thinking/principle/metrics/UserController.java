package com.csdn.design.patterns.thinking.principle.metrics;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 10:57
 */
public class UserController {

  private Metrics metrics = new Metrics();

  public UserController() {
    metrics.startRepeatedReport(60, TimeUnit.SECONDS);
  }

  public void register(Object user) {
    long startTimestamp = System.currentTimeMillis();
    metrics.recordTimestamps("register", System.currentTimeMillis());
    // ...
    long respTime = System.currentTimeMillis() - startTimestamp;
    metrics.recordResponseTime("register", respTime);
  }

  public void login(Object user) {
    long startTimestamp = System.currentTimeMillis();
    metrics.recordTimestamps("login", System.currentTimeMillis());
    // ...
    long respTime = System.currentTimeMillis() - startTimestamp;
    metrics.recordResponseTime("login", respTime);
  }
}
