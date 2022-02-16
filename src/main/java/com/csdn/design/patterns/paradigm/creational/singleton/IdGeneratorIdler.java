package com.csdn.design.patterns.paradigm.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 */
public class IdGeneratorIdler {

  private AtomicLong id = new AtomicLong(0);
  private static IdGeneratorIdler instance;

  private IdGeneratorIdler() {
  }

  public static synchronized IdGeneratorIdler getInstance() {
    if (null == instance) {
      instance = new IdGeneratorIdler();
    }

    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
