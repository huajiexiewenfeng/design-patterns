package com.csdn.design.patterns.theory.oop;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 10:36
 */
public class DynamicArray {

  /**
   * 默认数组初始大小
   */
  private static final int DEFAULT_CAPACITY = 10;

  private int size = 0;

  protected int capacity = DEFAULT_CAPACITY;

  protected Integer[] elements = new Integer[DEFAULT_CAPACITY];

  public int size() {
    return size;
  }

  public Integer get(int index) {
    return elements[index];
  }

  public void add(Integer e) {
    ensureCapacity();
    elements[size++] = e;
  }

  protected void ensureCapacity() {
    //...如果数组满了就扩容...代码省略...
  }

  public void addSize() {
    ++size;
  }


}
