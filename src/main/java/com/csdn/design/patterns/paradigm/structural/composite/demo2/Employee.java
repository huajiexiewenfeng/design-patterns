package com.csdn.design.patterns.paradigm.structural.composite.demo2;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:30
 */
public class Employee extends HumanResource {

  public Employee(long id, double salary) {
    super(id);
    this.salary = salary;
  }

  @Override
  public double calculateSalary() {
    return salary;
  }
}
