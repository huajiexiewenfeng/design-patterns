package com.csdn.design.patterns.paradigm.behavior.visitor.v1;


/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:31
 */
public class Extractor implements Visitor {

  @Override
  public void visit(PPTFile file) {
    System.out.println("Extract PPT.");
  }

  @Override
  public void visit(PdfFile file) {
    System.out.println("Extract Pdf.");
  }

  @Override
  public void visit(WordFile file) {
    System.out.println("Extract Word.");
  }
}
