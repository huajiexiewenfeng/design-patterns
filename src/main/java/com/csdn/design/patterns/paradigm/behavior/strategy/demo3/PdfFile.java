package com.csdn.design.patterns.paradigm.behavior.strategy.demo3;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:52
 */
public class PdfFile extends ResourceFile {

  public PdfFile(String filePath) {
    super(filePath);
  }

  @Override
  public ResourceFileType getType() {
    return ResourceFileType.PDF;
  }
}
