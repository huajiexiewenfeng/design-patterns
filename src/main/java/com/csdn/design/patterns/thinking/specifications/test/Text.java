package com.csdn.design.patterns.thinking.specifications.test;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 15:38
 */
public class Text {

  private String content;

  public Text(String content) {
    this.content = content;
  }

  public Integer toNumber() {
    if (content == null || content.isEmpty()) {
      return null;
    }
    try {
      return Integer.parseInt(content.trim());
    } catch (Exception e) {
      return null;
    }
  }
}
