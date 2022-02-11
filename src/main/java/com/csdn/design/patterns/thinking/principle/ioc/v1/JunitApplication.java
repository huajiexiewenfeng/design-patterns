package com.csdn.design.patterns.thinking.principle.ioc.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:41
 */
public class JunitApplication {

  private static final List<TestCase> testcases = new ArrayList<>();

  public static void register(TestCase testCase) {
    testcases.add(testCase);
  }

  public static void main(String[] args) {
    testcases.forEach(TestCase::run);
  }
}
