package com.csdn.design.patterns.thinking.principle.metrics.v1;

import java.util.List;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 11:16
 */
public interface MetricsStorage {

  void saveRequestInfo(RequestInfo requestInfo);

  List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

  Map<String,List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
