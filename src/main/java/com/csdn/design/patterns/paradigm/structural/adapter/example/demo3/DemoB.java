package com.csdn.design.patterns.paradigm.structural.adapter.example.demo3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:40
 */
public class DemoB {
  private BAdaptor bAdaptor;

  public DemoB(BAdaptor bAdaptor) {
    this.bAdaptor = bAdaptor;
  }

  public static void main(String[] args) {
    new DemoB(new BAdaptor(new B()));
  }
}
