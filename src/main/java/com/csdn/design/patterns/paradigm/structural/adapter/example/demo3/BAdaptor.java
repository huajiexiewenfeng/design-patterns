package com.csdn.design.patterns.paradigm.structural.adapter.example.demo3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:39
 */
public class BAdaptor implements IA {

  private B b;

  public BAdaptor(B b) {
    this.b = b;
  }

  @Override
  public void fa() {
    b.fb();
  }
}
