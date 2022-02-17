package com.csdn.design.patterns.paradigm.structural.flyweight.demo1.v1;

import com.csdn.design.patterns.paradigm.structural.flyweight.demo1.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:48
 */
public class ChessPieceUnitFactory {

  private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

  static {
    pieces.put(1, new ChessPieceUnit(1, "卒", Color.BLACK));
    pieces.put(2, new ChessPieceUnit(2, "帅", Color.BLACK));
    // ...
  }

  public static ChessPieceUnit getChessPieceUnit(int chessPieceId) {
    return pieces.get(chessPieceId);
  }

}
