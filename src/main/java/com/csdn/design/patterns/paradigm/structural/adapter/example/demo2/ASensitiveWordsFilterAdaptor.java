package com.csdn.design.patterns.paradigm.structural.adapter.example.demo2;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:29
 */
public class ASensitiveWordsFilterAdaptor extends ASensitiveWordsFilter implements
    ISensitiveWordsFilter {

  @Override
  public String filter(String text) {
    String maskedText = super.filterSexyWords(text);
    return super.filterPoliticalWords(maskedText);
  }
}
