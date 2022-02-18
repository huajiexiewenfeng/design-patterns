package com.csdn.design.patterns.paradigm.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 10:57
 */
public class StrategyFactory2 {

  public static Strategy getStrategy(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("type should not be empty.");
    }
    if (type.equals("A")) {
      return new ConcreteStrategyA();
    } else if (type.equals("B")) {
      return new ConcreteStrategyB();
    }
    return null;
  }
}
