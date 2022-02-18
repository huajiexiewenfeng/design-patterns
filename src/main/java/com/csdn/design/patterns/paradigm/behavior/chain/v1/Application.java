package com.csdn.design.patterns.paradigm.behavior.chain.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 14:09
 */
public class Application {

  public static void main(String[] args) {
    HandlerChain chain = new HandlerChain();
    chain.addHandler(new HandlerA());
    chain.addHandler(new HandlerB());
    chain.handle();
  }
}
