package com.csdn.design.patterns.project.ratelimiter;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 17:03
 */
public class InternalErrorException extends RuntimeException {

  public InternalErrorException(String message) {
    super(message);
  }

  public InternalErrorException(String message, Throwable cause) {
    super(message, cause);
  }
}
