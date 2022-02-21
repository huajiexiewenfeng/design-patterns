package com.csdn.design.patterns.paradigm.behavior.visitor.v1;


/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:32
 */
public class Compressor implements Visitor {

  @Override
  public void visit(PPTFile file) {
    System.out.println("Compressor PPT.");
  }

  @Override
  public void visit(PdfFile file) {
    System.out.println("Compressor Pdf.");
  }

  @Override
  public void visit(WordFile file) {
    System.out.println("Compressor Word.");
  }

}
