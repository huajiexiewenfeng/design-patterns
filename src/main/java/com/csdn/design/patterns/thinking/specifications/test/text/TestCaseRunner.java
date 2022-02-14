package com.csdn.design.patterns.thinking.specifications.test.text;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 15:41
 */
public class TestCaseRunner {

  public static void main(String[] args) {
    TextTest textTest = new TextTest();

    System.out.println("Run testToNumber");
    textTest.testToNumber();

    System.out.println("Run testToNumber_nullOrEmpty");
    textTest.testToNumber_nullOrEmpty();

    System.out.println("Run testToNumber_containsInvalidCharters");
    textTest.testToNumber_containsInvalidCharters();

    System.out.println("Run testToNumber_containsLeadingAndTrailingSpaces");
    textTest.testToNumber_containsLeadingAndTrailingSpaces();

    System.out.println("Run testToNumber_containsMultiLeadingAndTrailingSpaces");
    textTest.testToNumber_containsMultiLeadingAndTrailingSpaces();
  }

}
