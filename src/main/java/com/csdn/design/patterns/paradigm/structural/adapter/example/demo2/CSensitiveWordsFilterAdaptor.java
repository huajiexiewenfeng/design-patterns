package com.csdn.design.patterns.paradigm.structural.adapter.example.demo2;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:29
 */
public class CSensitiveWordsFilterAdaptor extends CSensitiveWordsFilter implements
    ISensitiveWordsFilter {

  @Override
  public String filter(String text) {
    return super.filter(text);
  }
}
