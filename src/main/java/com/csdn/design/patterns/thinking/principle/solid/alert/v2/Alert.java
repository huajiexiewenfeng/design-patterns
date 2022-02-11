package com.csdn.design.patterns.thinking.principle.solid.alert.v2;

import com.csdn.design.patterns.thinking.principle.solid.alert.AlertRule;
import com.csdn.design.patterns.thinking.principle.solid.alert.Notification;
import com.csdn.design.patterns.thinking.principle.solid.alert.NotificationEmergencyLevel;

/**
 * 添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，我们也要触发告警发送通知
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:12
 */
public class Alert {

  private AlertRule alertRule;
  private Notification notification;

  public Alert(AlertRule alertRule,
      Notification notification) {
    this.alertRule = alertRule;
    this.notification = notification;
  }

  public void check(String api, long requestCount, long errorCount, long timeoutCount,
      long durationOfSeconds) {
    long tps = requestCount / durationOfSeconds;
    if (tps > alertRule.getMatchRule(api).getMaxTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
    if (errorCount > alertRule.getMatchRule(api).getMaxErrorCount()) {
      notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }

    long timeoutTps = timeoutCount / durationOfSeconds;
    if (timeoutTps > alertRule.getMatchRule(api).getMaxTimeoutTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
  }
}
