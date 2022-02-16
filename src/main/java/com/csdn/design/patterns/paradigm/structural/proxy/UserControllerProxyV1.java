package com.csdn.design.patterns.paradigm.structural.proxy;

import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v3.MetricsCollector;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:10
 */
public class UserControllerProxyV1 extends UserController {

  private MetricsCollector metricsCollector;

  public UserControllerProxyV1(
      MetricsCollector metricsCollector) {
    this.metricsCollector = metricsCollector;
  }

  @Override
  public void register(Object user) {
    long startTimestamp = System.currentTimeMillis();
    // 委托
    super.register(user);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
  }

  @Override
  public void login(Object user) {
    long startTimestamp = System.currentTimeMillis();
    // 委托
    super.login(user);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
  }
}
