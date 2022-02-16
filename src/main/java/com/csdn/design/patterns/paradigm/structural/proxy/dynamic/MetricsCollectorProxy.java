package com.csdn.design.patterns.paradigm.structural.proxy.dynamic;

import com.csdn.design.patterns.thinking.principle.metrics.v3.MetricsCollector;
import java.lang.reflect.Proxy;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:16
 */
public class MetricsCollectorProxy<T> {

  private MetricsCollector metricsCollector;

  public MetricsCollectorProxy() {
    this.metricsCollector = new MetricsCollector();
  }

  public Object createProxy(T proxyObject) {
    Class<?>[] interfaces = proxyObject.getClass().getInterfaces();
    DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxyObject,
        metricsCollector);
    return Proxy
        .newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
  }
}
