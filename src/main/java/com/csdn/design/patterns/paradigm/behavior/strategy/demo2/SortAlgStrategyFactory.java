package com.csdn.design.patterns.paradigm.behavior.strategy.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 13:38
 */
public class SortAlgStrategyFactory {

  private static final Map<String, ISortAlg> algs = new HashMap<>();

  static {
    algs.put("QuickSort", new QuickSort());
    algs.put("ExternalSort", new ExternalSort());
    algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
    algs.put("MapReduceSort", new MapReduceSort());
  }

  public static ISortAlg getSortAlg(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("type should not be empty.");
    }
    return algs.get(type);
  }
}
