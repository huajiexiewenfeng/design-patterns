package com.csdn.design.patterns.thinking.specifications.test.transaction;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 17:13
 */
public class TransactionLock {

  public boolean lock(String id) {
    return RedisDistributedLock.getSingletonInstance().lockTransaction(id);
  }

  public void unlock(String id) {
    RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
  }
}
