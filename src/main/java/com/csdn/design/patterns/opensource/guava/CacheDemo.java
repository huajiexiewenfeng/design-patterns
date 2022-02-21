package com.csdn.design.patterns.opensource.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 10:58
 */
public class CacheDemo {

  public static void main(String[] args) {
    Cache<String, String> cache = CacheBuilder.newBuilder()
        .initialCapacity(100)
        .maximumSize(1000)
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .build();

    cache.put("key1", "value1");
    String value = cache.getIfPresent("key1");
    System.out.println(value);
  }
}
