package com.csdn.design.patterns.paradigm.behavior.visitor.v1;


/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:29
 */
public interface Visitor {

  void visit(PPTFile file);

  void visit(PdfFile file);

  void visit(WordFile file);

}
