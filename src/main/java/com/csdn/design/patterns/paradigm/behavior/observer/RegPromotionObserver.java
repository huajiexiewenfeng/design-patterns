package com.csdn.design.patterns.paradigm.behavior.observer;

import com.csdn.design.patterns.paradigm.behavior.observer.event.Subscribe;

public class RegPromotionObserver {

  private PromotionService promotionService = new PromotionService(); // 依赖注入

  @Subscribe
  public void handleRegSuccess(Long userId) {
    promotionService.issueNewUserExperienceCash(userId);
  }
}