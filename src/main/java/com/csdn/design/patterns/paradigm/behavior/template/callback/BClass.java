package com.csdn.design.patterns.paradigm.behavior.template.callback;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 10:19
 */
public class BClass {

  public void process(ICallback callback) {
    // ...
    System.out.println("前置操作");
    callback.methodToCallback("csdn");
    // ...
  }
}
