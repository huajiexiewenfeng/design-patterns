package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsCollector;
import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RedisMetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 17:12
 */
public class Demo {

  public static void main(String[] args) {
    MetricsStorage metricsStorage = new RedisMetricsStorage();
    Aggregator aggregator = new Aggregator();

    // 定时触发统计并将结果显示到终端
    ConsoleViewer consoleViewer = new ConsoleViewer();
    ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage, aggregator,
        consoleViewer);
    consoleReporter.startRepeatedReport(60, 60);

    // 定时触发统计并将结果输出到邮件
    EmailViewer emailViewer = new EmailViewer();
    emailViewer.addToAddress("csdn@xwf.com");
    EmailReporter emailReporter = new EmailReporter(metricsStorage, aggregator, emailViewer);
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
