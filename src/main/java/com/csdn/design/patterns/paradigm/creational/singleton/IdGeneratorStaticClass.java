package com.csdn.design.patterns.paradigm.creational.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * @author xiewenfeng
 */
public class IdGeneratorStaticClass {

  private AtomicLong id = new AtomicLong(0);

  private IdGeneratorStaticClass() {
  }

  private static class SingletonHolder {

    private static final IdGeneratorStaticClass instance = new IdGeneratorStaticClass();
  }

  public static synchronized IdGeneratorStaticClass getInstance() {
    return SingletonHolder.instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
