package com.csdn.design.patterns.paradigm.behavior.chain.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 14:00
 */
public abstract class Handler {

  protected Handler successor = null;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }

  public abstract void handle();
}
