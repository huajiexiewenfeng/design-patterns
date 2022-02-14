package com.csdn.design.patterns.thinking.principle.metrics.v1;

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
  private EmailSender emailSender;
  private List<String> toAddress = new ArrayList<>();

  public EmailReporter(
      MetricsStorage metricsStorage) {
    this(metricsStorage, new EmailSender());
  }

  public EmailReporter(
      MetricsStorage metricsStorage,
      EmailSender emailSender) {
    this.metricsStorage = metricsStorage;
    this.emailSender = emailSender;
  }

  public void addToAddress(String address) {
    this.toAddress.add(address);
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
        Map<String, RequestStat> stats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
          String apiName = entry.getKey();
          List<RequestInfo> requestInfosPerApi = entry.getValue();
          // 根据原始数据计算统计数据
          RequestStat aggregate = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
          stats.put(apiName, aggregate);
        }
        // 发送邮件 ...
      }
    }, firstTime, DAY_HOURS_IN_SECONDS * 1000);

  }

}
