package com.csdn.design.patterns.paradigm.structural.flyweight.demo2.v1;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:11
 */
public class Character {

  private char c;
  private CharacterStyle style;

  public Character(char c,
      CharacterStyle style) {
    this.c = c;
    this.style = style;
  }
}
