package com.csdn.design.patterns.paradigm.structural.flyweight.demo1;

import com.csdn.design.patterns.paradigm.structural.flyweight.demo1.Color;

/**
 * 棋子
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:41
 */
public class ChessPiece {

  private int id;
  private String text;
  private Color color;
  private int positionX;
  private int positionY;

  public ChessPiece(int id, String text,
      Color color, int positionX, int positionY) {
    this.id = id;
    this.text = text;
    this.color = color;
    this.positionX = positionX;
    this.positionY = positionY;
  }
}
