package com.csdn.design.patterns.thinking.oop.composition;

/**
 * 鸵鸟
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/9 16:50
 */
public class Ostrich implements EggLayable, Tweetable {

  private TweetAbility tweetAbility = new TweetAbility();

  private EggLayAbility eggLayAbility = new EggLayAbility();

  @Override
  public void layEgg() {
    eggLayAbility.layEgg();
  }

  @Override
  public void tweet() {
    tweetAbility.tweet();
  }
}
