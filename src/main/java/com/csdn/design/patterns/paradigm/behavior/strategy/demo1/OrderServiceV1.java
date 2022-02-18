package com.csdn.design.patterns.paradigm.behavior.strategy.demo1;

public class OrderServiceV1 {

  public double discount(Order order) {
    OrderType type = order.getType();
    DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
    return discountStrategy.calDiscount(order);
  }
}