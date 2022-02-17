package com.csdn.design.patterns.paradigm.structural.adapter.example.demo3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:38
 */
public class Demo {
  private IA a;

  public Demo(IA a) {
    this.a = a;
  }

  public static void main(String[] args) {
    new Demo(new A());
  }
}
