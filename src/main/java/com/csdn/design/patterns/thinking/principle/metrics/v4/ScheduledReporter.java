package com.csdn.design.patterns.thinking.principle.metrics.v4;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import com.csdn.design.patterns.thinking.principle.metrics.v2.Aggregator;
import com.csdn.design.patterns.thinking.principle.metrics.v2.StatViewer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 17:25
 */
public abstract class ScheduledReporter {

  private static final long MAX_STAT_DURATION_IN_MILLIS = 10 * 60 * 1000;

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
    Map<String, RequestStat> stats = doStat(startTimeInMillis, endTimeInMillis);
    statViewer.output(stats, startTimeInMillis, endTimeInMillis);
  }

  private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeInMillis) {
    Map<String, List<RequestStat>> segmentStats = new HashMap<>();
    long segmentStatTimeInMillis = startTimeInMillis;
    while (segmentStatTimeInMillis < endTimeInMillis) {
      long segmentEndTimeMillis = segmentStatTimeInMillis + MAX_STAT_DURATION_IN_MILLIS;
      if (segmentEndTimeMillis > endTimeInMillis) {
        segmentEndTimeMillis = endTimeInMillis;
      }
      /**
       * 每一次查询10分钟时间段
       */
      Map<String, List<RequestInfo>> requestInfos = metricsStorage
          .getRequestInfos(segmentStatTimeInMillis, segmentEndTimeMillis);

      if (requestInfos == null || requestInfos.isEmpty()) {
        // 继续查询下一个时间段
        continue;
      }
      Map<String, RequestStat> segmentStat = aggregator
          .aggregate(requestInfos, segmentEndTimeMillis - segmentStatTimeInMillis);
      addStat(segmentStats, segmentStat);
      segmentStatTimeInMillis += MAX_STAT_DURATION_IN_MILLIS;
    }
    long durationInMillis = endTimeInMillis - startTimeInMillis;
    Map<String, RequestStat> aggregatedStats = aggregateStats(segmentStats, durationInMillis);
    return aggregatedStats;
  }

  private Map<String, RequestStat> aggregateStats(Map<String, List<RequestStat>> segmentStats,
      long durationInMillis) {
    Map<String, RequestStat> aggregatedStats = new HashMap<>();
    segmentStats.forEach((apiName, apiStats) -> {
      double maxRespTime = Double.MIN_VALUE;
      double minRespTime = Double.MAX_VALUE;
      long count = 0;
      double sumRespTime = 0;
      for (RequestStat stat : apiStats) {
        if (stat.getMaxResponseTime() > maxRespTime) {
          maxRespTime = stat.getMaxResponseTime();
        }
        if (stat.getMinResponseTime() < minRespTime) {
          minRespTime = stat.getMinResponseTime();
        }
        count += stat.getCount();
        sumRespTime += (stat.getCount() * stat.getAvgResponseTime());
      }
      RequestStat aggregatedStat = new RequestStat();
      aggregatedStat.setMaxResponseTime(maxRespTime);
      aggregatedStat.setMinResponseTime(minRespTime);
      aggregatedStat.setAvgResponseTime(sumRespTime / count);
      aggregatedStat.setCount(count);
      aggregatedStat.setTps(count / durationInMillis * 1000);
      aggregatedStats.put(apiName, aggregatedStat);
    });
    return aggregatedStats;
  }

  protected void addStat(Map<String, List<RequestStat>> segmentStats,
      Map<String, RequestStat> segmentStat) {
    segmentStat.forEach((apiName, requestStat) -> {
      List<RequestStat> requestStats = segmentStats.putIfAbsent(apiName, new ArrayList<>());
      requestStats.add(requestStat);
    });
  }
}
