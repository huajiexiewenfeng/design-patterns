package com.csdn.design.patterns.paradigm.behavior.observer.event;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 15:04
 */
public class EventBus {

  private Executor executor;
  private ObserverRegistry observerRegistry = new ObserverRegistry();

  public EventBus() {
    this(MoreExecutors.directExecutor());
  }

  protected EventBus(Executor executor) {
    this.executor = executor;
  }

  public void register(Object object) {
    observerRegistry.registry(object);
  }

  public void post(Object event) {
    List<ObserverAction> observerActions = observerRegistry.getMatchedObserverActions(event);
    for (ObserverAction action : observerActions) {
      executor.execute(() -> {
        action.execute(event);
      });
    }
  }
}
