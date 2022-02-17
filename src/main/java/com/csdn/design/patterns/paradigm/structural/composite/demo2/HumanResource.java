package com.csdn.design.patterns.paradigm.structural.composite.demo2;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:29
 */
public abstract class HumanResource {

  protected long id;
  protected double salary;

  public HumanResource(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public abstract double calculateSalary();
}
