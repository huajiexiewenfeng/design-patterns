package com.csdn.design.patterns.opensource.guava;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 11:12
 */
public class ImmutableDemo {

  public static void main(String[] args) {
    List<String> originalList = new ArrayList<>();
    originalList.add("a");
    originalList.add("b");
    originalList.add("c");

    List<String> jdkUnmodifiableList = Collections.unmodifiableList(originalList);
    List<String> guavaImmutableList = ImmutableList.copyOf(originalList);

//    jdkUnmodifiableList.add("d");UnsupportedOperationException
//    guavaImmutableList.add("d"); UnsupportedOperationException
    originalList.add("d");
    print(originalList); // a b c d
    print(jdkUnmodifiableList); // a b c d
    print(guavaImmutableList); // a b c
  }

  private static void print(List<String> list) {
    list.forEach(System.out::print);
    System.out.println();
  }

}
