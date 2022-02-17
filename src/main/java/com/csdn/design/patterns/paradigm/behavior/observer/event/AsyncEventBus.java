package com.csdn.design.patterns.paradigm.behavior.observer.event;

import java.util.concurrent.Executor;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 15:05
 */
public class AsyncEventBus extends EventBus {

  public AsyncEventBus(Executor executor) {
    super(executor);
  }
}
