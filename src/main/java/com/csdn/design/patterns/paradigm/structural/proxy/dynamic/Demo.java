package com.csdn.design.patterns.paradigm.structural.proxy.dynamic;

import com.csdn.design.patterns.paradigm.structural.proxy.IUserController;
import com.csdn.design.patterns.paradigm.structural.proxy.UserController;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:22
 */
public class Demo {

  public static void main(String[] args) {
    MetricsCollectorProxy<UserController> proxy = new MetricsCollectorProxy<>();
    IUserController userController = (IUserController)proxy.createProxy(new UserController());
    userController.login(new Object());
  }

}
