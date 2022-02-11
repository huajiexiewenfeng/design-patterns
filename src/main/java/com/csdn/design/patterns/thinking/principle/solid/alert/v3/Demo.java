package com.csdn.design.patterns.thinking.principle.solid.alert.v3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:53
 */
public class Demo {

  public static void main(String[] args) {
    ApiStatInfo apiStatInfo = new ApiStatInfo();
    ApplicationContext.getInstance().getAlert().check(apiStatInfo);
  }
}
