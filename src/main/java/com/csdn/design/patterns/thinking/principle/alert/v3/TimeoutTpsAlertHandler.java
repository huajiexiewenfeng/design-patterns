package com.csdn.design.patterns.thinking.principle.alert.v3;

import com.csdn.design.patterns.thinking.principle.alert.AlertRule;
import com.csdn.design.patterns.thinking.principle.alert.Notification;
import com.csdn.design.patterns.thinking.principle.alert.NotificationEmergencyLevel;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:37
 */
public class TimeoutTpsAlertHandler extends AbstractAlertHandler {

  public TimeoutTpsAlertHandler(AlertRule alertRule,
      Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    long timeoutTps = apiStatInfo.getTimeoutCount() / apiStatInfo.getDurationOfSeconds();
    if (timeoutTps > alertRule.getMatchRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
      notification.notify(NotificationEmergencyLevel.URGENCY, "...");
    }
  }
}
