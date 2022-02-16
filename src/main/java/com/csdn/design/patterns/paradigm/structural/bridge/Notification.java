package com.csdn.design.patterns.paradigm.structural.bridge;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:49
 */
public abstract class Notification {

  protected MsgSender msgSender;

  public Notification(MsgSender msgSender) {
    this.msgSender = msgSender;
  }

  public abstract void notify(String msg);
}
