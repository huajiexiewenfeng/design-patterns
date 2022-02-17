package com.csdn.design.patterns.paradigm.behavior.observer;

import com.csdn.design.patterns.paradigm.behavior.observer.event.AsyncEventBus;
import com.csdn.design.patterns.paradigm.behavior.observer.event.EventBus;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 17:54
 */
public class UserController {

  private UserService userService;
  private EventBus eventBus;
  private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

  public UserController() {
    eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    userService = new UserService();
  }

  public void setRegObservers(List<Object> observers) {
    for (Object observer : observers) {
      eventBus.register(observer);
    }
  }

  public Long register(String telephone, String password) {
    //省略输入参数的校验代码
    // 省略userService.register()异常的try-catch代码
    long userId = userService.register(telephone, password);
    eventBus.post(userId);
    return userId;
  }

  public static void main(String[] args) {
    UserController userController = new UserController();
    userController.setRegObservers(Arrays.asList(new RegNotificationObserver(),new RegPromotionObserver()));
    userController.register("123","xwf");
  }

}
