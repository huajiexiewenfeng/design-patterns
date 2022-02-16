package com.csdn.design.patterns.paradigm.structural.proxy;

import com.csdn.design.patterns.thinking.principle.metrics.Metrics;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v3.MetricsCollector;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:06
 */
public class UserControllerProxy implements IUserController {

  private UserController userController;
  private MetricsCollector metricsCollector;

  public UserControllerProxy(
      UserController userController,
      MetricsCollector metricsCollector) {
    this.userController = userController;
    this.metricsCollector = metricsCollector;
  }

  @Override
  public void register(Object user) {
    long startTimestamp = System.currentTimeMillis();
    // 委托
    userController.register(user);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
  }

  @Override
  public void login(Object user) {
    long startTimestamp = System.currentTimeMillis();
    // 委托
    userController.login(user);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
  }
}
