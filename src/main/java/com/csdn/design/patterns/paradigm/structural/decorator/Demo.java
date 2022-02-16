package com.csdn.design.patterns.paradigm.structural.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 装饰模式，避免较深的继承层次
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/16 17:09
 * @see FilterInputStream
 */
public class Demo {

  public static void main(String[] args) throws IOException {
    test1();
    test2();
  }

  public static void test1() throws IOException {
    try (InputStream in = new FileInputStream("");) {
      byte[] data = new byte[128];
      while (in.read(data) != -1) {
        //...
      }
    }
  }

  /**
   * 通过这种方式可以将继承 InputStream 的多个子类组合在一起使用，达到增强的效果
   *
   * @throws IOException
   */
  public static void test2() throws IOException {
    InputStream in = new FileInputStream("");
    try (BufferedInputStream stream = new BufferedInputStream(in)) {
      byte[] data = new byte[128];
      while (stream.read(data) != -1) {
        //...
      }
    }
  }
}