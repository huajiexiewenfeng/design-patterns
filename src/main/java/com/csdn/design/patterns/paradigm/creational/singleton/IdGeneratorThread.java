package com.csdn.design.patterns.paradigm.creational.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程单例
 */
public class IdGeneratorThread {

  private AtomicLong id = new AtomicLong(0);
  private static final Map<Long, IdGeneratorThread> instances = new ConcurrentHashMap<>();

  private IdGeneratorThread() {
  }

  public static IdGeneratorThread getInstance() {
    long threadId = Thread.currentThread().getId();
    IdGeneratorThread idGeneratorThread = instances
        .putIfAbsent(threadId, new IdGeneratorThread());
    return idGeneratorThread;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
