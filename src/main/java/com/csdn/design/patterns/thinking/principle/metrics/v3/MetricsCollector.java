package com.csdn.design.patterns.thinking.principle.metrics.v3;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.Executors;
import org.springframework.util.ObjectUtils;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 11:16
 */
public class MetricsCollector {

  private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
  private MetricsStorage metricsStorage;
  private EventBus eventBus;

  public MetricsCollector(
      MetricsStorage metricsStorage) {
    this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
  }

  public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
    this.metricsStorage = metricsStorage;
    this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
    this.eventBus.register(new EventListener(metricsStorage));
  }

  public void recordRequest(RequestInfo requestInfo) {
    if (requestInfo == null || ObjectUtils.isEmpty(requestInfo.getApiName())) {
      return;
    }
    eventBus.post(requestInfo);
  }
}
