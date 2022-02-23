package com.csdn.design.patterns.project.idempotence;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/23 10:52
 */
public class RedisClusterIdempotenceStorage implements IdempotenceStorage {

  private static final String ADDRESS_SEPARATOR = ";";

  private JedisCluster jedisCluster;

  /**
   * @param redisClusterAddress redisClusterAddress the format is 128.91.12.1:3455;128.91.12.2:3452;289.13.2.12:8978
   * @param config              config should not be null
   */
  public RedisClusterIdempotenceStorage(String redisClusterAddress,
      GenericObjectPoolConfig config) {
    this.jedisCluster = new JedisCluster(parseHostAndPorts(redisClusterAddress), config);
  }

  /**
   * Save {@idempotenceId} into storage if it does not exist.
   *
   * @param idempotenceId the idempotence ID
   * @return true if the {@idempotenceId} is saved, otherwise return false
   */
  @Override
  public boolean saveIfAbsent(String idempotenceId) {
    Long success = jedisCluster.setnx(idempotenceId, "1");
    return success == 1;
  }

  @Override
  public void delete(String idempotenceId) {
    jedisCluster.del(idempotenceId);
  }

  private Set<HostAndPort> parseHostAndPorts(String redisClusterAddress) {
    String[] addressArray = redisClusterAddress.split(ADDRESS_SEPARATOR);
    Set<HostAndPort> redisNodes = new HashSet<>();
    for (String address : addressArray) {
      String[] hostAndPort = address.split(":");
      redisNodes.add(new HostAndPort(hostAndPort[0], Integer.valueOf(hostAndPort[1])));
    }
    return redisNodes;
  }
}
