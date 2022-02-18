package com.csdn.design.patterns.paradigm.behavior.chain.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 14:06
 */
public class HandlerChain {

  private Handler head = null;
  private Handler tail = null;

  public void addHandler(Handler handler) {
    if (head == null) {
      head = handler;
      tail = handler;
      return;
    }
    tail.setSuccessor(handler);
    tail = handler;
  }

  public void handle() {
    if (head != null) {
      head.handle();
    }
  }

}
