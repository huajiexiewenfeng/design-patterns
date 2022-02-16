package com.csdn.design.patterns.paradigm.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 分布式集群环境下单例
 */
public class IdGeneratorDistributed {

  private AtomicLong id = new AtomicLong(0);
  private static SharedObjectStorage storage = new FileSharedObjectStorage();
  private static DistributedLock lock = new DistributedLock();
  private static IdGeneratorDistributed instance;

  private IdGeneratorDistributed() {
  }

  public synchronized static IdGeneratorDistributed getInstance() {
    if (null == instance) {
      lock.lock();
      instance = storage.load(IdGeneratorDistributed.class);
    }
    return instance;
  }

  public synchronized void freeInstance() {
    storage.save(this, IdGeneratorDistributed.class);
    instance = null; //释放对象
    lock.unlock();
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
