package com.csdn.design.patterns.paradigm.behavior.strategy.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 11:17
 */
public class DiscountStrategyFactory {

  private static final Map<OrderType, DiscountStrategy> discountStrategies = new HashMap<>();

  static {
    discountStrategies.put(OrderType.NORMAL, new NormalDiscountStrategy());
    discountStrategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
    discountStrategies.put(OrderType.GROUPON, new GrouponDiscountStrategy());
  }

  public static DiscountStrategy getDiscountStrategy(OrderType orderType) {
    return discountStrategies.get(orderType);
  }

}
