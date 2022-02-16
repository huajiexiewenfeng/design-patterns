package com.csdn.design.patterns.thinking.principle.metrics.v3;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import com.csdn.design.patterns.thinking.principle.metrics.v2.Aggregator;
import com.csdn.design.patterns.thinking.principle.metrics.v2.StatViewer;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 17:25
 */
public abstract class ScheduledReporter {

  private MetricsStorage metricsStorage;
  private StatViewer statViewer;
  private Aggregator aggregator;

  public ScheduledReporter(
      MetricsStorage metricsStorage,
      StatViewer statViewer,
      Aggregator aggregator) {
    this.metricsStorage = metricsStorage;
    this.statViewer = statViewer;
    this.aggregator = aggregator;
  }

  protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
    long durationInMillis = endTimeInMillis -  startTimeInMillis;
    Map<String, List<RequestInfo>> requestInfos = metricsStorage
        .getRequestInfos(startTimeInMillis, endTimeInMillis);
    Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
    statViewer.output(stats, startTimeInMillis, endTimeInMillis);
  }
}
