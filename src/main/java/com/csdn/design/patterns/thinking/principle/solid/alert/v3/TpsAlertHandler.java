package com.csdn.design.patterns.thinking.principle.solid.alert.v3;

import com.csdn.design.patterns.thinking.principle.solid.alert.AlertRule;
import com.csdn.design.patterns.thinking.principle.solid.alert.Notification;
import com.csdn.design.patterns.thinking.principle.solid.alert.NotificationEmergencyLevel;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:37
 */
public class TpsAlertHandler extends AbstractAlertHandler {

  public TpsAlertHandler(AlertRule alertRule,
      Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
    if (tps > alertRule.getMatchRule(apiStatInfo.getApi()).getMaxTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
  }
}
