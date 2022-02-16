package com.csdn.design.patterns.paradigm.creational.prototype;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 15:44
 */
public class DemoV4 {

  private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
  private long lastUpdateTime = -1;

  public void refresh() {
    // shallow copy
    HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();

    // 从数据库中取出更新时间>lastUpdateTime的数据，放入到currentKeywords中
    List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
    long maxNewUpdatedTime = lastUpdateTime;
    for (SearchWord searchWord : toBeUpdatedSearchWords) {
      if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
        maxNewUpdatedTime = searchWord.getLastUpdateTime();
      }
      // 需要更新的 SearchWord 对象，我们再使用深度拷贝的方式创建一份新的对象
      if (newKeywords.containsKey(searchWord.getKeyword())) {
        newKeywords.remove(searchWord.getKeyword());
      }
      newKeywords.put(searchWord.getKeyword(), searchWord);
    }
    lastUpdateTime = maxNewUpdatedTime;
    currentKeywords = newKeywords;
  }

  private List<SearchWord> getSearchWords(long lastUpdateTime) {
    // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
    return null;
  }
}
