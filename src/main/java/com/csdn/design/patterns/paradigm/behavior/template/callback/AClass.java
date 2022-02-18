package com.csdn.design.patterns.paradigm.behavior.template.callback;


/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 10:20
 */
public class AClass {

  public static void main(String[] args) {
    BClass b = new BClass();
    b.process((msg) -> {
      System.out.println("call back me. msg:[" + msg + "]"
      );
    });
  }

}
