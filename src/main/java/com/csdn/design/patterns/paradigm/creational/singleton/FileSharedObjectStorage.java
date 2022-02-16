package com.csdn.design.patterns.paradigm.creational.singleton;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:02
 */
public class FileSharedObjectStorage implements SharedObjectStorage {

  @Override
  public IdGeneratorDistributed load(Class<IdGeneratorDistributed> idGeneratorDistributedClass) {
    return null;
  }

  @Override
  public void save(IdGeneratorDistributed idGeneratorDistributed,
      Class<IdGeneratorDistributed> idGeneratorDistributedClass) {

  }
}
