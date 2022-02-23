package com.csdn.design.patterns.project.idempotence;

import java.util.UUID;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/23 10:44
 */
public class UUIDGenerator implements IdempotenceIdGenerator {

  @Override
  public String generate() {
    return UUID.randomUUID().toString();
  }
}
