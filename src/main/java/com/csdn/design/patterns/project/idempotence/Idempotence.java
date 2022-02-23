package com.csdn.design.patterns.project.idempotence;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/23 10:26
 */
public class Idempotence {

  private IdempotenceStorage idempotenceStorage;

  public Idempotence(IdempotenceStorage idempotenceStorage) {
    this.idempotenceStorage = idempotenceStorage;
  }

  public boolean saveIfAbsent(String idempotenceId) {
    return idempotenceStorage.saveIfAbsent(idempotenceId);
  }

  public void delete(String idempotenceId) {
    idempotenceStorage.delete(idempotenceId);
  }

}
