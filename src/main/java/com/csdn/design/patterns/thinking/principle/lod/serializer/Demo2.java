package com.csdn.design.patterns.thinking.principle.lod.serializer;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 17:01
 */
public class Demo2 {

  private Deserializable<Object> deserializer;

  public Demo2(
      Deserializable<Object> deserializer) {
    this.deserializer = deserializer;
  }
}
