package com.csdn.design.patterns.thinking.principle.lod.serializer;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:55
 */
public interface Deserializable<T> {

  T deserialize(String text);
}
