package com.csdn.design.patterns.project.darklaunch;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/23 13:59
 */
public class DarkDemo {

  public static void main(String[] args) {
    test1();
    test2();
  }

  private static void test1() {
    DarkLaunch darkLaunch = new DarkLaunch();
    IDarkFeature darkFeature = darkLaunch.getDarkFeature("call_newapi_getUserById");
    darkFeature.enabled();
    darkFeature.dark(123);
  }

  /**
   * 自定义灰度规则
   */
  private static void test2() {
    DarkLaunch darkLaunch = new DarkLaunch();
    darkLaunch.addProgrammedDarkFeature("user_promotion", new UserPromotionDarkRule());
    IDarkFeature darkFeature = darkLaunch.getDarkFeature("user_promotion");
    darkFeature.enabled();
    darkFeature.dark(123);
  }
}
