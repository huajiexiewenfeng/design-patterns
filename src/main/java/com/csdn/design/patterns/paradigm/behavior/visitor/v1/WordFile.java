package com.csdn.design.patterns.paradigm.behavior.visitor.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:07
 */
public class WordFile extends ResourceFile {

  public WordFile(String filePath) {
    super(filePath);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

}
