package com.csdn.design.patterns.paradigm.behavior.strategy.demo2.v2;

import com.csdn.design.patterns.paradigm.behavior.strategy.demo2.ISortAlg;
import com.csdn.design.patterns.paradigm.behavior.strategy.demo2.QuickSort;
import com.csdn.design.patterns.paradigm.behavior.strategy.demo2.SortAlgStrategyFactory;
import com.csdn.design.patterns.paradigm.structural.adapter.example.demo3.A;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 13:42
 */
public class Sorter {

  private static final long GB = 1024 * 1024 * 1024;
  private static final List<AlgRange> algs = new ArrayList<>();

  static {
    algs.add(new AlgRange(0, 6 * GB, SortAlgStrategyFactory.getSortAlg("QuickSort")));
    algs.add(new AlgRange(6, 10 * GB, SortAlgStrategyFactory.getSortAlg("ExternalSort")));
    algs.add(new AlgRange(10, 100 * GB, SortAlgStrategyFactory.getSortAlg("ConcurrentExternalSort")));
    algs.add(new AlgRange(100, Long.MAX_VALUE, SortAlgStrategyFactory.getSortAlg("MapReduceSort")));
  }

  public void sortFile(String filePath) {
    // 省略校验逻辑
    File file = new File(filePath);
    long fileSize = file.length();
    ISortAlg sortAlg = null;
    for (AlgRange algRange : algs) {
      if (algRange.inRange(fileSize)) {
        sortAlg = algRange.getSortAlg();
        break;
      }
    }
    sortAlg.sort(filePath);
  }

}
