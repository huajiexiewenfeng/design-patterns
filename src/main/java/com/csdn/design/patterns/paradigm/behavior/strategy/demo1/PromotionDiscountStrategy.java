package com.csdn.design.patterns.paradigm.behavior.strategy.demo1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 11:17
 */
public class PromotionDiscountStrategy implements DiscountStrategy{

  @Override
  public double calDiscount(Order order) {
    return 0;
  }
}
