package com.csdn.design.patterns.paradigm.structural.flyweight.demo1.v1;

import com.csdn.design.patterns.paradigm.structural.flyweight.demo1.Color;
import lombok.Data;

/**
 * 享元类
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:47
 */
@Data
public class ChessPieceUnit {

  private int id;
  private String text;
  private Color color;

  public ChessPieceUnit(int id, String text, Color color) {
    this.id = id;
    this.text = text;
    this.color = color;
  }
}
