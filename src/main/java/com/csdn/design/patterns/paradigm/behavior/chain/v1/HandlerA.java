package com.csdn.design.patterns.paradigm.behavior.chain.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 14:04
 */
public class HandlerA extends Handler {

  @Override
  public void handle() {
    boolean handled = false;
    // ...
    System.out.println("handler-a...");
    if (!handled && successor != null) {
      successor.handle();
    }
  }
}
