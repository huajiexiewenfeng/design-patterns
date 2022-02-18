package com.csdn.design.patterns.paradigm.behavior.strategy.demo2.v1;

import com.csdn.design.patterns.paradigm.behavior.strategy.demo2.ISortAlg;
import com.csdn.design.patterns.paradigm.behavior.strategy.demo2.SortAlgStrategyFactory;
import java.io.File;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 13:42
 */
public class Sorter {

  private static final long GB = 1024 * 1024 * 1024;

  public void sortFile(String filePath) {
    // 省略校验逻辑
    File file = new File(filePath);
    long fileSize = file.length();
    ISortAlg sortAlg;
    if (fileSize < 6 * GB) { // [0, 6GB)
      sortAlg = SortAlgStrategyFactory.getSortAlg("QuickSort");
    } else if (fileSize < 10 * GB) { // [6GB, 10GB)
      sortAlg = SortAlgStrategyFactory.getSortAlg("ExternalSort");
    } else if (fileSize < 100 * GB) { // [10GB, 100GB)
      sortAlg = SortAlgStrategyFactory.getSortAlg("ConcurrentExternalSort");
    } else { // [100GB, ~)
      sortAlg = SortAlgStrategyFactory.getSortAlg("MapReduceSort");
    }
    sortAlg.sort(filePath);
  }

}
