package com.csdn.design.patterns.thinking.oop.composition;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 16:51
 */
public class Sparrow implements Flyable, EggLayable, Tweetable {

  private FlyAbility flyAbility = new FlyAbility();

  private TweetAbility tweetAbility = new TweetAbility();

  private EggLayAbility eggLayAbility = new EggLayAbility();

  @Override
  public void layEgg() {
    eggLayAbility.layEgg();
  }

  @Override
  public void fly() {
    flyAbility.fly();
  }

  @Override
  public void tweet() {
    tweetAbility.tweet();
  }
}
