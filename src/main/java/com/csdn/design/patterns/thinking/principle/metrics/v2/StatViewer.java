package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 16:55
 */
public interface StatViewer {

  void output(Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMillis);
}
