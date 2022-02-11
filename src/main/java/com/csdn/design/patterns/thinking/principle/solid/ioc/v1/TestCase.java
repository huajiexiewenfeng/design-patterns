package com.csdn.design.patterns.thinking.principle.solid.ioc.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:41
 */
public abstract class TestCase {

  public void run() {
    if (doTest()) {
      System.out.println("succeed");
    } else {
      System.out.println("failed");
    }
  }

  public abstract boolean doTest();
}
