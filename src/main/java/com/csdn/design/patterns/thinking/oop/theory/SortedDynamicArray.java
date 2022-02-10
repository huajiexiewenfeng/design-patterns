package com.csdn.design.patterns.thinking.oop.theory;

/**
 * 继承 + @Override 重写的方式来实现多态特性
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/9 10:45
 */
public class SortedDynamicArray extends DynamicArray {

  @Override
  public void add(Integer e) {
    // 扩容
    ensureCapacity();
    int i;
    for (i = size() - 1; i >= 0; --i) {
      if (elements[i] > e) {
        elements[i + 1] = elements[i];
      } else {
        break;
      }
    }
    elements[i + 1] = e;
    addSize();
  }
}
