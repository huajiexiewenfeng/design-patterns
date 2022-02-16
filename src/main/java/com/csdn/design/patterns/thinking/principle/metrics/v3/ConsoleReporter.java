package com.csdn.design.patterns.thinking.principle.metrics.v3;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RedisMetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import com.csdn.design.patterns.thinking.principle.metrics.v2.Aggregator;
import com.csdn.design.patterns.thinking.principle.metrics.v2.ConsoleViewer;
import com.csdn.design.patterns.thinking.principle.metrics.v2.StatViewer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:20
 */
public class ConsoleReporter extends ScheduledReporter {

  private ScheduledExecutorService scheduledExecutorService;

  public ConsoleReporter() {
    this(new RedisMetricsStorage(), new ConsoleViewer(), new Aggregator());
  }

  public ConsoleReporter(
      MetricsStorage metricsStorage,
      StatViewer statViewer,
      Aggregator aggregator) {
    super(metricsStorage, statViewer, aggregator);
    scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  }

  public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
    scheduledExecutorService.scheduleAtFixedRate(() -> {
      // 根据给定时间从数据库中获取
      long durationInMillis = durationInSeconds * 1000;
      long endTimeInMillis = System.currentTimeMillis();
      long startTimeInMillis = endTimeInMillis - durationInMillis;
      doStatAndReport(startTimeInMillis, endTimeInMillis);
    }, 0, periodInSeconds, TimeUnit.SECONDS);
  }

}
