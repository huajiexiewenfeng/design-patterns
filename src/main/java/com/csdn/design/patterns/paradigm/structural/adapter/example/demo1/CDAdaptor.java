package com.csdn.design.patterns.paradigm.structural.adapter.example.demo1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:22
 */
public class CDAdaptor extends CD implements ITarget {

  @Override
  public void function1() {
    super.staticFunction1();
  }

  @Override
  public void function2() {
    super.uglyNamingFunction2();
  }

  @Override
  public void fucntion3(ParamsWrapperDefinition paramsWrapper) {
    super.tooManyParamsFunction3(paramsWrapper.getParam1(), paramsWrapper.getParam2());
  }

  @Override
  public void function4() {
    super.lowPerformanceFunction4();
  }
}
