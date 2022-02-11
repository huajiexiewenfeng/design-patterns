package com.csdn.design.patterns.thinking.principle.solid.hotupdate;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:08
 */
public class ScheduledUpdater implements Runnable{

  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  ;
  private long initialDelay;
  private long period;
  private Updater updater;

  public ScheduledUpdater(Updater updater, long initialDelay, long period) {
    this.initialDelay = initialDelay;
    this.period = period;
    this.updater = updater;
  }

  @Override
  public void run() {
    executor
        .scheduleAtFixedRate((Runnable) () -> this.updater.update(), this.initialDelay, this.period,
            TimeUnit.SECONDS);
  }
}
