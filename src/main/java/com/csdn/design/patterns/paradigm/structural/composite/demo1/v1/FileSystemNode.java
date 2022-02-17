package com.csdn.design.patterns.paradigm.structural.composite.demo1.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:21
 */
public abstract class FileSystemNode {

  protected String path;

  public FileSystemNode(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public abstract int countNumOfFiles();

  public abstract long countSizeOfFiles();
}
