package com.csdn.design.patterns.thinking.principle.solid.alert.v1;

import com.csdn.design.patterns.thinking.principle.solid.alert.AlertRule;
import com.csdn.design.patterns.thinking.principle.solid.alert.Notification;
import com.csdn.design.patterns.thinking.principle.solid.alert.NotificationEmergencyLevel;

/**
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

  public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
    long tps = requestCount / durationOfSeconds;
    if (tps > alertRule.getMatchRule(api).getMaxTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
    if (errorCount > alertRule.getMatchRule(api).getMaxErrorCount()) {
      notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }
  }
}
