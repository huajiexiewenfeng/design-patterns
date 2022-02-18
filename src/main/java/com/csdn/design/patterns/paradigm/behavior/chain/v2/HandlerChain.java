package com.csdn.design.patterns.paradigm.behavior.chain.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 14:06
 */
public class HandlerChain {

  private List<IHandler> handlers = new ArrayList<>();

  public void addHandler(IHandler handler) {
    this.handlers.add(handler);
  }

  public void handle() {
    for (IHandler handler : handlers) {
      boolean handle = handler.handle();
      if (!handle) {
        break;
      }
    }
  }

}
