package com.csdn.design.patterns.thinking.principle.metrics;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 10:25
 */
public class Metrics {

  /**
   * key:接口名称 value:接口响应时间
   */
  private Map<String, List<Double>> responseTimes = new HashMap<>();
  /**
   * key:接口名称 value:接口时间戳
   */
  private Map<String, List<Double>> timestamps = new HashMap<>();

  private ScheduledExecutorService scheduledExecutorService = Executors
      .newSingleThreadScheduledExecutor();

  public void recordResponseTime(String apiName, double responseTime) {
    responseTimes.putIfAbsent(apiName, new ArrayList<>());
    responseTimes.get(apiName).add(responseTime);
  }

  public void recordTimestamps(String apiName, double timestamp) {
    responseTimes.putIfAbsent(apiName, new ArrayList<>());
    responseTimes.get(apiName).add(timestamp);
  }

  public void startRepeatedReport(long period, TimeUnit timeUnit) {
    scheduledExecutorService.scheduleAtFixedRate(() -> {
      Map<String, Map<String, Double>> stats = new HashMap<>();
      // 统计最大值和平均值
      responseTimes.forEach((apiName, apiRespTimes) -> {
        stats.putIfAbsent(apiName, new HashMap<>());
        stats.get(apiName).put("max", max(apiRespTimes));
        stats.get(apiName).put("min", min(apiRespTimes));
      });

      //计算总数
      timestamps.forEach((apiName, apiTimestamps) -> {
        stats.putIfAbsent(apiName, new HashMap<>());
        stats.get(apiName).put("count", (double) apiTimestamps.size());
      });
      System.out.println(JSON.toJSONString(stats));
    }, 0, period, timeUnit);
  }

  private Double max(List<Double> responseTimes) {
    return null;
  }

  private Double min(List<Double> responseTimes) {
    return null;
  }
}
