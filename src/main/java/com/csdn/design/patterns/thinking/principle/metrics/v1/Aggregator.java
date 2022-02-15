package com.csdn.design.patterns.thinking.principle.metrics.v1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:02
 */
public class Aggregator {

  public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
    double maxRespTime = Double.MIN_VALUE;
    double minRespTime = Double.MAX_VALUE;
    double avgRespTime = -1;
    double p999RespTime = -1;
    double p99RespTime = -1;
    double sumRespTime = 0;
    long count = 0;
    // 计算统计值
    for (RequestInfo requestInfo : requestInfos) {
      count++;
      double responseTime = requestInfo.getResponseTime();
      if (maxRespTime < responseTime) {
        maxRespTime = responseTime;
      }
      if (minRespTime > responseTime) {
        minRespTime = responseTime;
      }
      sumRespTime += responseTime;
    }
    if (count != 0) {
      avgRespTime = sumRespTime / count;
    }
    long tps = count / durationInMillis * 1000;
    // 按照返回时间排序
    Collections.sort(requestInfos, (o1, o2) -> {
      double diff = o1.getResponseTime() - o2.getResponseTime();
      if (diff < 0.0) {
        return -1;
      } else if (diff > 0.0) {
        return 1;
      } else {
        return 0;
      }
    });
    int idx999 = (int) (count * 0.999);
    int idx99 = (int) (count * 0.99);
    if (count != 0) {
      p999RespTime = requestInfos.get(idx999).getResponseTime();
      p99RespTime = requestInfos.get(idx99).getResponseTime();
    }
    // 封装
    RequestStat requestStat = new RequestStat();
    requestStat.setMaxResponseTime(maxRespTime);
    requestStat.setMinResponseTime(minRespTime);
    requestStat.setAvgResponseTime(avgRespTime);
    requestStat.setP999ResponseTime(p999RespTime);
    requestStat.setP99ResponseTime(p99RespTime);
    requestStat.setCount(count);
    requestStat.setTps(tps);
    return requestStat;
  }
}
