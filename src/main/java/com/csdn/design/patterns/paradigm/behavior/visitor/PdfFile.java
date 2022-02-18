package com.csdn.design.patterns.paradigm.behavior.visitor;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:07
 */
public class PdfFile extends ResourceFile {

  public PdfFile(String filePath) {
    super(filePath);
  }

  @Override
  public void extract2txt() {
    //...省略一大坨从PPT中抽取文本的代码...
    // ...将抽取出来的文本保存在跟filePath同名的.txt文件中...
    System.out.println("Extract Pdf.");
  }
}
