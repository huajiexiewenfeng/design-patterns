package com.csdn.design.patterns.thinking.principle.solid.alert.v3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 10:53
 */
public class Demo {

  public static void main(String[] args) {
    ApiStatInfo apiStatInfo = new ApiStatInfo();
    apiStatInfo.setErrorCount(10);
    ApplicationContext.getInstance().getAlert().check(apiStatInfo);
  }
}
