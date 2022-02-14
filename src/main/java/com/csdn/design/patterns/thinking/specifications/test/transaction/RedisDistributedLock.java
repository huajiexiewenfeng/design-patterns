package com.csdn.design.patterns.thinking.specifications.test.transaction;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 16:46
 */
public class RedisDistributedLock {

  private static final RedisDistributedLock INSTANCE = new RedisDistributedLock();

  public static RedisDistributedLock getSingletonInstance() {
    return INSTANCE;
  }

  public boolean lockTransaction(String id) {
    return false;
  }

  public void unlockTransaction(String id){

  }
}
