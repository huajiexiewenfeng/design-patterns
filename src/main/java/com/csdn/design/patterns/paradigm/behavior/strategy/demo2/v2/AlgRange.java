package com.csdn.design.patterns.paradigm.behavior.strategy.demo2.v2;

import com.csdn.design.patterns.paradigm.behavior.strategy.demo2.ISortAlg;
import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 13:46
 */
@Data
public class AlgRange {

  private long start;
  private long end;
  private ISortAlg sortAlg;

  public AlgRange(long start, long end,
      ISortAlg sortAlg) {
    this.start = start;
    this.end = end;
    this.sortAlg = sortAlg;
  }

  public boolean inRange(long fileSize) {
    return fileSize >= start && fileSize < end;
  }
}
