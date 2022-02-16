package com.csdn.design.patterns.paradigm.creational.prototype;

import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 15:27
 */
@Data
public class SearchWord {

  private long lastUpdateTime;
  private String keyword;
  private int count;

  public SearchWord(String keyword, int count, long lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    this.keyword = keyword;
    this.count = count;
  }
}
