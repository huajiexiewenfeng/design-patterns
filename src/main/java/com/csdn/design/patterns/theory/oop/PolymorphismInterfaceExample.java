package com.csdn.design.patterns.theory.oop;

/**
 * 多态示例-接口
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/9 10:52
 */
public class PolymorphismInterfaceExample {

  public static void main(String[] args) {
    // 子类可以替换父类
    Iterator arrayIterator = new Array();
    println(arrayIterator);

    Iterator linkedListIterator = new LinkedList();
    println(linkedListIterator);
  }

  private static void println(Iterator iterator) {
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
