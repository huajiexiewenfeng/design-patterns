package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.csdn.design.patterns.thinking.principle.metrics.v1.EmailSender;
import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:31
 */
public class EmailReporter {

  private static final long DAY_HOURS_IN_SECONDS = 86400L;

  private MetricsStorage metricsStorage;
  private StatViewer statViewer;
  private Aggregator aggregator;

  public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator,
      StatViewer statViewer) {
    this.metricsStorage = metricsStorage;
    this.statViewer = statViewer;
    this.aggregator = aggregator;
  }

  public void startDailyReport() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    Date firstTime = calendar.getTime();
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
        long endTimeInMillis = System.currentTimeMillis();
        long startTimeInMillis = endTimeInMillis - durationInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage
            .getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
        statViewer.output(stats, startTimeInMillis, endTimeInMillis);
      }
    }, firstTime, DAY_HOURS_IN_SECONDS * 1000);

  }

}
