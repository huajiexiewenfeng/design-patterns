package com.csdn.design.patterns.paradigm.creational.singleton;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:02
 */
public interface SharedObjectStorage {

  IdGeneratorDistributed load(Class<IdGeneratorDistributed> idGeneratorDistributedClass);

  void save(IdGeneratorDistributed idGeneratorDistributed, Class<IdGeneratorDistributed> idGeneratorDistributedClass);
}
