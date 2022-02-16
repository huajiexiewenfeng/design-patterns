package com.csdn.design.patterns.paradigm.structural.proxy.dynamic;

import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v3.MetricsCollector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:19
 */
public class DynamicProxyHandler implements InvocationHandler {

  private Object proxyObject;

  private MetricsCollector metricsCollector;

  public DynamicProxyHandler(Object proxyObject, MetricsCollector metricsCollector) {
    this.proxyObject = proxyObject;
    this.metricsCollector = metricsCollector;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long startTimestamp = System.currentTimeMillis();
    Object result = method.invoke(proxyObject, args);
    long endTimeStamp = System.currentTimeMillis();
    long responseTime = endTimeStamp - startTimestamp;
    String apiName = proxyObject.getClass().getName() + ":" + method.getName();
    RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
    metricsCollector.recordRequest(requestInfo);
    return result;
  }
}
