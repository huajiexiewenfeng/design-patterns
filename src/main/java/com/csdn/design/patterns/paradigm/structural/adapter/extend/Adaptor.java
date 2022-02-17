package com.csdn.design.patterns.paradigm.structural.adapter.extend;

/**
 * 类适配器：基于继承
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:12
 */
public class Adaptor extends Adaptee implements ITarget {

  @Override
  public void function1() {
    super.functionA();
  }

  @Override
  public void function2() {
    super.functionB();
  }

  @Override
  public void function3() {
    super.functionC();
  }
}
