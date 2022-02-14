package com.csdn.design.patterns.thinking.principle.metrics.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:58
 */
public class Demo {

  public static void main(String[] args) {
    MetricsStorage metricsStorage = new RedisMetricsStorage();
    ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage);
    consoleReporter.startRepeatedReport(60, 60);

    EmailReporter emailReporter = new EmailReporter(metricsStorage);
    emailReporter.addToAddress("csdn@xwf.com");
    emailReporter.startDailyReport();

    MetricsCollector metricsCollector = new MetricsCollector(metricsStorage);
    metricsCollector.recordRequest(new RequestInfo("register", 100, 10200));
    metricsCollector.recordRequest(new RequestInfo("login", 100, 10200));

    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
