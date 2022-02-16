package com.csdn.design.patterns.paradigm.structural.bridge;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:51
 */
public class UrgencyNotification extends Notification {

  public UrgencyNotification(MsgSender msgSender) {
    super(msgSender);
  }

  @Override
  public void notify(String msg) {
    msgSender.send(msg);
  }
}
