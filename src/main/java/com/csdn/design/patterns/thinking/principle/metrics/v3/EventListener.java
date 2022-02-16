package com.csdn.design.patterns.thinking.principle.metrics.v3;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.google.common.eventbus.Subscribe;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 18:19
 */
public class EventListener {

  private MetricsStorage metricsStorage;

  public EventListener(
      MetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  @Subscribe
  public void saveRequestInfo(RequestInfo requestInfo) {
    metricsStorage.saveRequestInfo(requestInfo);
  }
}
