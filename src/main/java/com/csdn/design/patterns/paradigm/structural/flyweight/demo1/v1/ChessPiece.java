package com.csdn.design.patterns.paradigm.structural.flyweight.demo1.v1;


/**
 * 棋子
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:41
 */
public class ChessPiece {

  private ChessPieceUnit chessPieceUnit;
  private int positionX;
  private int positionY;

  public ChessPiece(
      ChessPieceUnit chessPieceUnit, int positionX, int positionY) {
    this.chessPieceUnit = chessPieceUnit;
    this.positionX = positionX;
    this.positionY = positionY;
  }
}
