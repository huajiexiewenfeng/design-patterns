package com.csdn.design.patterns.thinking.principle.metrics.v1;

import java.util.List;

/**
 * redis 统计存储实现
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/14 13:52
 */
public class RedisMetricsStorage implements MetricsStorage {

  @Override
  public void saveRequestInfo(RequestInfo requestInfo) {

  }

  @Override
  public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis,
      long endTimeInMillis) {
    return null;
  }

  @Override
  public List<RequestInfo> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
    return null;
  }
}
