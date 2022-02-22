package com.csdn.design.patterns.project.ratelimiter.alg;

import com.csdn.design.patterns.project.ratelimiter.InternalErrorException;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 16:11
 */
public class FixedTimeWinRateLimitAlg implements RateLimitAlg {

  private static final long TRY_LOCK_TIMEOUT = 200L;
  private Stopwatch stopwatch;
  private AtomicInteger currentCount = new AtomicInteger();
  private final int limit;
  private final int unit;
  private Lock lock = new ReentrantLock();

  public FixedTimeWinRateLimitAlg(int limit, int unit) {
    this(Stopwatch.createStarted(), limit, unit);
  }

  public FixedTimeWinRateLimitAlg(Stopwatch stopwatch, int limit, int unit) {
    this.stopwatch = stopwatch;
    this.limit = limit;
    this.unit = unit;
  }

  /**
   * 判断接口是否限流
   *
   * @return
   */
  @Override
  public boolean tryAcquire() {
    int updatedCount = currentCount.incrementAndGet();
    if (updatedCount < limit) {
      return true;
    }
    try {
      if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MICROSECONDS)) {
        try {
          if (stopwatch.elapsed(TimeUnit.MICROSECONDS) > TimeUnit.SECONDS.toMillis(unit)) {
            currentCount.set(0);
            stopwatch.reset();
          }
          updatedCount = currentCount.incrementAndGet();
          return updatedCount <= limit;
        } finally {
          lock.unlock();
        }
      } else {
        throw new InternalErrorException(
            "tryAcquire() wait lock too long:" + TRY_LOCK_TIMEOUT + "ms");
      }
    } catch (InterruptedException e) {
      throw new InternalErrorException("tryAcquire() is interrupted by lock-time-out.", e);
    }
  }

  public static void main(String[] args) {
    AtomicInteger count = new AtomicInteger(0);
    System.out.println(count.incrementAndGet());
    System.out.println(count.incrementAndGet());
  }
}
