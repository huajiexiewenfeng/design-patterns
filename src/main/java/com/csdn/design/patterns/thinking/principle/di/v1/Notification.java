package com.csdn.design.patterns.thinking.principle.di.v1;

import com.csdn.design.patterns.thinking.principle.di.ordinary.MessageSender;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 15:10
 */
public class Notification {

  private MessageSender messageSender;

  public Notification(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public void sendMessage(String cellphone, String message) {
    messageSender.send(cellphone, message);
  }
}
