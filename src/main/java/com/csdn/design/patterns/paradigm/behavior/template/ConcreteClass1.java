package com.csdn.design.patterns.paradigm.behavior.template;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 10:14
 */
public class ConcreteClass1 extends AbstractClass {

  @Override
  protected void method2() {

  }

  @Override
  protected void method1() {

  }

  public static void main(String[] args) {
    AbstractClass clazz = new ConcreteClass1();
    clazz.templateMethod();
  }
}
