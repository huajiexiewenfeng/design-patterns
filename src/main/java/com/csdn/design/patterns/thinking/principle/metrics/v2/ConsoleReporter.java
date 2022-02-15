package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.csdn.design.patterns.thinking.principle.metrics.v2.Aggregator;
import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:20
 */
public class ConsoleReporter {

  private MetricsStorage metricsStorage;
  private ScheduledExecutorService scheduledExecutorService;
  private StatViewer statViewer;
  private Aggregator aggregator;

  public ConsoleReporter(
      MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
    this.aggregator = aggregator;
    this.statViewer = viewer;
    this.metricsStorage = metricsStorage;
    scheduledExecutorService = Executors
        .newSingleThreadScheduledExecutor();
  }

  public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
    scheduledExecutorService.scheduleAtFixedRate(() -> {
      // 根据给定时间从数据库中获取
      long durationInMillis = durationInSeconds * 1000;
      long endTimeInMillis = System.currentTimeMillis();
      long startTimeInMillis = endTimeInMillis - durationInMillis;
      Map<String, List<RequestInfo>> requestInfos = metricsStorage
          .getRequestInfos(startTimeInMillis, endTimeInMillis);
      Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
      statViewer.output(stats, startTimeInMillis, endTimeInMillis);
    }, 0, periodInSeconds, TimeUnit.SECONDS);
  }

}
