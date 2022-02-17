package com.csdn.design.patterns.paradigm.structural.flyweight.demo2;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:57
 */
public class Character {

  private char c;
  private Font font;
  private int size;
  private int colorRGB;

  public Character(char c, Font font, int size, int colorRGB) {
    this.c = c;
    this.font = font;
    this.size = size;
    this.colorRGB = colorRGB;
  }
}
