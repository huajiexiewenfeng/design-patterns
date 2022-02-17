package com.csdn.design.patterns.paradigm.structural.adapter.example.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 10:33
 */
public class RiskManagement {

  private List<ISensitiveWordsFilter> filters = new ArrayList<>();

  public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
    filters.add(filter);
  }

  public String filterSensitiveWords(String text) {
    String maskedText = text;
    for (ISensitiveWordsFilter filter : filters) {
      maskedText = filter.filter(maskedText);
    }
    return maskedText;
  }
}
