package com.csdn.design.patterns.paradigm.behavior.observer;

import com.csdn.design.patterns.paradigm.behavior.observer.event.Subscribe;

public class RegNotificationObserver {

  private NotificationService notificationService = new NotificationService();

  @Subscribe
  public void handleRegSuccess(Long userId) {
    notificationService.sendInboxMessage(userId, "...");
  }
}