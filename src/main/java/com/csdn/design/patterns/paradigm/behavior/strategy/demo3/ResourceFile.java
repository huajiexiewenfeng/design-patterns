package com.csdn.design.patterns.paradigm.behavior.strategy.demo3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:49
 */
public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }
  public abstract ResourceFileType getType();
}
