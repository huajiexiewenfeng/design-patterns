package com.csdn.design.patterns.paradigm.behavior.observer.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标明观察者中的哪个函数可以接收消息
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 15:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

}
