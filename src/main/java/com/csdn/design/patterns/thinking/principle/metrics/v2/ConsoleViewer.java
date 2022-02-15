package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.alibaba.fastjson.JSON;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 16:56
 */
public class ConsoleViewer implements StatViewer {

  @Override
  public void output(Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMillis) {
    System.out.println("Time Span:[" + startTimeInMillis + "~" + endTimeInMillis + "]");
    System.out.println(JSON.toJSONString(stats));
  }
}
