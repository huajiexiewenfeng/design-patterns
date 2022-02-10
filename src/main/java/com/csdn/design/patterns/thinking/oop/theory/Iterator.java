package com.csdn.design.patterns.thinking.oop.theory;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 11:03
 */
public interface Iterator {

  boolean hasNext();

  String next();

  String remove();

  default String test() {
    return null;
  }

}
