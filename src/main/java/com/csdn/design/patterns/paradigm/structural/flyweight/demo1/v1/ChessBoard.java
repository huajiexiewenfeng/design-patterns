package com.csdn.design.patterns.paradigm.structural.flyweight.demo1.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋局
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:44
 */
public class ChessBoard {

  private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

  public ChessBoard() {
    init();
  }

  private void init() {
    chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPieceUnit(1), 0, 0));
    chessPieces.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPieceUnit(2), 0, 1));
    // ...
  }

  public void move(int chessPieceId, int toPositionX, int toPositionY) {

  }

}
