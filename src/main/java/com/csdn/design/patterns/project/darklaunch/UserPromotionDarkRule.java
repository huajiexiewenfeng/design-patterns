package com.csdn.design.patterns.project.darklaunch;

/**
 * @Author: xiewenfeng
 * @Date: 2022/3/4 15:58
 */
public class UserPromotionDarkRule implements IDarkFeature {

  @Override
  public boolean enabled() {
    return true;
  }

  @Override
  public boolean dark(long darkTarget) {
    return false;
  }

  @Override
  public boolean dark(String darkTarget) {
    return false;
  }
}
