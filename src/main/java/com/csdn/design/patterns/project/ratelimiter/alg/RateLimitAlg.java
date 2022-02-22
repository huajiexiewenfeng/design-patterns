package com.csdn.design.patterns.project.ratelimiter.alg;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:54
 */
public interface RateLimitAlg {

  boolean tryAcquire();
}
