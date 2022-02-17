package com.csdn.design.patterns.paradigm.structural.flyweight;


/**
 * IntegerCache 采用了享元模式设计 -128 and 127 使用的是缓存
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:41
 * @see Integer
 */
public class Demo {

  public static void main(String[] args) {
    Integer a = 56;
    Integer b = 56;
    System.out.println(a == b);
    Integer c = 128;
    Integer d = 128;
    System.out.println(c == d);
  }

}
