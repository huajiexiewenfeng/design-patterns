package com.csdn.design.patterns.paradigm.behavior.template;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 10:13
 */
public abstract class AbstractClass {

  public final void templateMethod() {
    method1();
    method2();
  }

  protected abstract void method2();

  protected abstract void method1();
}
