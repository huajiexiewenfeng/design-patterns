package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestInfo;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:02
 */
public class Aggregator {

  public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos,
      long durationInMillis) {
    Map<String, RequestStat> requestStats = new HashMap<>();
    // 计算统计值
    requestInfos.forEach((aipName, requestInfosPerApi) -> {
      RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
      requestStats.put(aipName, requestStat);
    });
    return requestStats;
  }

  public RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
    List<Double> respTimes = new ArrayList<>();
    // 计算统计值
    for (RequestInfo requestInfo : requestInfos) {
      double responseTime = requestInfo.getResponseTime();
      respTimes.add(responseTime);
    }
    // 封装
    RequestStat requestStat = new RequestStat();
    requestStat.setMaxResponseTime(max(respTimes));
    requestStat.setMinResponseTime(min(respTimes));
    requestStat.setAvgResponseTime(avg(respTimes));
    requestStat.setP999ResponseTime(percentile999(respTimes));
    requestStat.setP99ResponseTime(percentile99(respTimes));
    requestStat.setCount(respTimes.size());
    requestStat.setTps((long) tps(respTimes.size(), durationInMillis));
    return requestStat;
  }

  private double max(List<Double> dataset) {
    double maxRespTime = Double.MIN_VALUE;
    for (Double respTime : dataset) {
      if (maxRespTime < respTime) {
        maxRespTime = respTime;
      }
    }
    return maxRespTime;
  }

  private double min(List<Double> dataset) {
    double minRespTime = Double.MAX_VALUE;
    for (Double responseTime : dataset) {
      if (minRespTime > responseTime) {
        minRespTime = responseTime;
      }
    }
    return minRespTime;
  }

  private double avg(List<Double> dataset) {
    double sumRespTime = 0;
    for (Double responseTime : dataset) {
      sumRespTime += responseTime;
    }
    return sumRespTime;
  }

  private double tps(int count, double durationInMillis) {
    return count / durationInMillis * 1000;
  }

  private double percentile999(List<Double> dataset) {
    int count = dataset.size();
    sortList(dataset);
    int idx999 = (int) (count * 0.999);
    if (count != 0) {
      return dataset.get(idx999);
    } else {
      return 0;
    }
  }

  private double percentile99(List<Double> dataset) {
    int count = dataset.size();
    sortList(dataset);
    int idx99 = (int) (count * 0.99);
    if (count != 0) {
      return dataset.get(idx99);
    } else {
      return 0;
    }
  }

  private void sortList(List<Double> dataset) {
    // 按照返回时间排序
    Collections.sort(dataset, (o1, o2) -> {
      double diff = o1 - o2;
      if (diff < 0.0) {
        return -1;
      } else if (diff > 0.0) {
        return 1;
      } else {
        return 0;
      }
    });
  }

}
