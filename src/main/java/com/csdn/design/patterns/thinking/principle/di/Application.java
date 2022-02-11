package com.csdn.design.patterns.thinking.principle.di;

import com.csdn.design.patterns.thinking.principle.di.ordinary.MessageSender;
import com.csdn.design.patterns.thinking.principle.di.v1.Notification;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 15:11
 */
public class Application {

  public static void main(String[] args) {
    noDI();
    DI();
  }

  private static void noDI() {
    com.csdn.design.patterns.thinking.principle.di.ordinary.Notification notification = new com.csdn.design.patterns.thinking.principle.di.ordinary.Notification();
    notification.sendMessage("", "");
  }

  private static void DI() {
    MessageSender messageSender = new MessageSender();
    Notification notification = new Notification(messageSender);
    notification.sendMessage("", "");
  }

}
