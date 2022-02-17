package com.csdn.design.patterns.paradigm.behavior.observer;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 17:58
 */
public class NotificationService {

  public void sendInboxMessage(Long userId, String s) {
    System.out.println("NotificationService.sendInboxMessage:" + userId + "-" + s);
  }
}
