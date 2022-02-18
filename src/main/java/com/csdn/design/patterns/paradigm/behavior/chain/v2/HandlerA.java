package com.csdn.design.patterns.paradigm.behavior.chain.v2;


/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 14:04
 */
public class HandlerA implements IHandler {

  @Override
  public boolean handle() {
    boolean handled = false;
    // ...
    System.out.println("handler-a...");
    return handled;
  }
}
