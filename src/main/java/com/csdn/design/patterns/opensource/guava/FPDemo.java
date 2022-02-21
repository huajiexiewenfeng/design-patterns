package com.csdn.design.patterns.opensource.guava;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 13:40
 */
public class FPDemo {

  public static void main(String[] args) {
    Optional<Integer> result = Stream.of("f", "ba", "csdn")
        .map(String::length)
        .filter(l -> l <= 3)
        .max((o1, o2) -> o1 - o2);
    System.out.println(result.get());
  }
}
