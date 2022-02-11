package com.csdn.design.patterns.thinking.principle.alert.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:26
 */
public class Alert {

  /**
   * 这里具有扩展性，可以应对多种新增场景
   */
  private final List<AbstractAlertHandler> alertHandlers = new ArrayList<>();

  public void addAlertHandler(AbstractAlertHandler alertHandler) {
    this.alertHandlers.add(alertHandler);
  }

  public void check(ApiStatInfo apiStatInfo) {
    // spring 中有很多类似的设计
    for (AbstractAlertHandler alertHandler : alertHandlers) {
      alertHandler.check(apiStatInfo);
    }
  }

}
