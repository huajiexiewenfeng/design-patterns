package com.csdn.design.patterns.thinking.principle.solid.alert.v3;

import com.csdn.design.patterns.thinking.principle.solid.alert.AlertRule;
import com.csdn.design.patterns.thinking.principle.solid.alert.Notification;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:49
 */
public class ApplicationContext {

  private AlertRule alertRule;
  private Notification notification;
  private Alert alert;

  public void initializeBeans() {
    alertRule = new AlertRule();
    notification = new Notification();
    alert = new Alert();
    alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
    alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    alert.addAlertHandler(new TimeoutTpsAlertHandler(alertRule, notification));
  }

  public Alert getAlert() {
    return alert;
  }

  /**
   * 饿汉式单例
   */
  private static final ApplicationContext instance = new ApplicationContext();

  private ApplicationContext() {
    initializeBeans();
  }

  public static ApplicationContext getInstance() {
    return instance;
  }
}
