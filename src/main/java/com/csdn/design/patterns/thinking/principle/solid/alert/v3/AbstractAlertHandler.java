package com.csdn.design.patterns.thinking.principle.solid.alert.v3;

import com.csdn.design.patterns.thinking.principle.solid.alert.AlertRule;
import com.csdn.design.patterns.thinking.principle.solid.alert.Notification;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:27
 */
public abstract class AbstractAlertHandler {

  protected AlertRule alertRule;
  protected Notification notification;

  public AbstractAlertHandler(AlertRule alertRule,
      Notification notification) {
    this.alertRule = alertRule;
    this.notification = notification;
  }

  public abstract void check(ApiStatInfo apiStatInfo);
}
