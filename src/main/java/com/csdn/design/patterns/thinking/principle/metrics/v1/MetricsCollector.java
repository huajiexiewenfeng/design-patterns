package com.csdn.design.patterns.thinking.principle.metrics.v1;

import org.springframework.util.ObjectUtils;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 11:16
 */
public class MetricsCollector {

  private MetricsStorage metricsStorage;

  public MetricsCollector(
      MetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  public void recordRequest(RequestInfo requestInfo) {
    if (requestInfo == null || ObjectUtils.isEmpty(requestInfo.getApiName())) {
      return;
    }
    metricsStorage.saveRequestInfo(requestInfo);
  }
}
