package com.csdn.design.patterns.thinking.principle.lod.serializer;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 17:01
 */
public class Demo1 {

  private Serializable<Object> serializer;

  public Demo1(Serializable<Object> serializer) {
    this.serializer = serializer;
  }
}
