package com.csdn.design.patterns.thinking.principle.di.ordinary;

/**
 * 非 DI 实现
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/11 15:06
 */
public class Notification {

  private MessageSender messageSender;

  public Notification() {
    this.messageSender = new MessageSender();
  }

  public void sendMessage(String cellphone, String message) {
    messageSender.send(cellphone, message);
  }
}
