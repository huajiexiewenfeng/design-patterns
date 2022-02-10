package com.csdn.design.patterns.theory.oop;

/**
 * 多态示例-继承
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/9 10:52
 */
public class PolymorphismExtendsExample {

  public static void main(String[] args) {
    // 子类可以替换父类
    DynamicArray dynamicArray = new SortedDynamicArray();
    test(dynamicArray);
  }

  private static void test(DynamicArray dynamicArray) {
    dynamicArray.add(3);
    dynamicArray.add(1);
    dynamicArray.add(2);
    for (int i = 0; i < dynamicArray.size(); i++) {
      System.out.println(dynamicArray.get(i));
    }
  }
}
