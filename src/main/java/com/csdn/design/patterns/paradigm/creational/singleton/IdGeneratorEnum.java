package com.csdn.design.patterns.paradigm.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 */
public enum IdGeneratorEnum {

  INSTANCE;
  private AtomicLong id = new AtomicLong(0);

  public long getId() {
    return id.incrementAndGet();
  }
}
