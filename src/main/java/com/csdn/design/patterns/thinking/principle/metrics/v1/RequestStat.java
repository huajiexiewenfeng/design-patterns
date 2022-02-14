package com.csdn.design.patterns.thinking.principle.metrics.v1;

import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 14:03
 */
@Data
public class RequestStat {

  private double maxResponseTime;
  private double minResponseTime;
  private double avgResponseTime;
  private double p999ResponseTime;
  private double p99ResponseTime;
  private long count;
  private long tps;
}
