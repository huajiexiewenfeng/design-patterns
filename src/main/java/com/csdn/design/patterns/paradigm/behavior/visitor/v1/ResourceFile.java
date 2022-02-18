package com.csdn.design.patterns.paradigm.behavior.visitor.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:03
 */
public abstract class ResourceFile {

  protected String filePath;

  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }

  public abstract void accept(Visitor visitor);
}
