package com.csdn.design.patterns.thinking.principle.metrics.v3;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RedisMetricsStorage;

import com.csdn.design.patterns.thinking.principle.metrics.v2.Aggregator;
import com.csdn.design.patterns.thinking.principle.metrics.v2.EmailViewer;
import com.csdn.design.patterns.thinking.principle.metrics.v2.StatViewer;
import com.google.common.annotations.VisibleForTesting;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:31
 */
public class EmailReporter extends ScheduledReporter {

  private static final long DAY_HOURS_IN_SECONDS = 86400L;

  public EmailReporter(
      MetricsStorage metricsStorage,
      StatViewer statViewer,
      Aggregator aggregator) {
    super(metricsStorage, statViewer, aggregator);
  }

  public EmailReporter(List<String> emailToAddresses) {
    this(new RedisMetricsStorage(), new EmailViewer(emailToAddresses), new Aggregator());
  }

  public void startDailyReport() {
    Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
        long endTimeInMillis = System.currentTimeMillis();
        long startTimeInMillis = endTimeInMillis - durationInMillis;
        doStatAndReport(startTimeInMillis, endTimeInMillis);
      }
    }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
  }

  @VisibleForTesting
  protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

}
