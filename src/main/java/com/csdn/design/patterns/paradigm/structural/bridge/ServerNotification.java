package com.csdn.design.patterns.paradigm.structural.bridge;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:50
 */
public class ServerNotification extends Notification {

  public ServerNotification(MsgSender msgSender) {
    super(msgSender);
  }

  @Override
  public void notify(String msg) {
    msgSender.send(msg);
  }
}
