package com.csdn.design.patterns.thinking.principle.metrics.v1;

import com.alibaba.fastjson.JSON;
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

  public ConsoleReporter(
      MetricsStorage metricsStorage) {
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
      Map<String, RequestStat> stats = new HashMap<>();
      for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
        String apiName = entry.getKey();
        List<RequestInfo> requestInfosPerApi = entry.getValue();
        // 根据原始数据计算统计数据
        RequestStat aggregate = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
        stats.put(apiName, aggregate);
      }
      System.out.println("Time Span:[" + startTimeInMillis + "~" + endTimeInMillis + "]");
      System.out.println(JSON.toJSONString(stats));
    }, 0, periodInSeconds, TimeUnit.SECONDS);
  }

}
