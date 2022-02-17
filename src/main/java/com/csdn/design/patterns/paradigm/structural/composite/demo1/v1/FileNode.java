package com.csdn.design.patterns.paradigm.structural.composite.demo1.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:22
 */
public class FileNode extends FileSystemNode {

  public FileNode(String path) {
    super(path);
  }

  @Override
  public int countNumOfFiles() {
    return 1;
  }

  @Override
  public long countSizeOfFiles() {
    java.io.File file = new java.io.File(path);
    if (!file.exists()) {
      return 0;
    }
    return file.length();
  }
}
