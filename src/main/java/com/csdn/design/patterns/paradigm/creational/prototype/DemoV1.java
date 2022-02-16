package com.csdn.design.patterns.paradigm.creational.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * a & b 两个版本的数据互不影响
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/16 15:27
 */
public class DemoV1 {

  private Map<String, SearchWord> currentKeywords = new HashMap<>();

  public void refresh() {
    HashMap<String, SearchWord> newKeyWords = new HashMap<>();
    // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中
    List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
    for (SearchWord searchWord : toBeUpdatedSearchWords) {
      newKeyWords.put(searchWord.getKeyword(), searchWord);
    }
    currentKeywords = newKeyWords;
  }

  private List<SearchWord> getSearchWords() {
    // TODO: 从数据库中取出所有
    return null;
  }
}
