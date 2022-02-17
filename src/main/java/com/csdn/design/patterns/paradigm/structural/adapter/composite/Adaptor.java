package com.csdn.design.patterns.paradigm.structural.adapter.composite;

import com.csdn.design.patterns.paradigm.structural.adapter.extend.Adaptee;
import com.csdn.design.patterns.paradigm.structural.adapter.extend.ITarget;

/**
 * 对象适配器：基于组合
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:15
 */
public class Adaptor implements ITarget {

  private Adaptee adaptee;

  public Adaptor(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void function1() {
    adaptee.functionA();
  }

  @Override
  public void function2() {
    adaptee.functionB();
  }

  @Override
  public void function3() {
    adaptee.functionC();
  }
}
