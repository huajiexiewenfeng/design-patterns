package com.csdn.design.patterns.paradigm.structural.flyweight.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 13:59
 */
public class Editor {

  private List<Character> chars = new ArrayList<>();

  public void appendCharacter(char c, Font font, int size, int colorRGB) {
    Character character = new Character(c, font, size, colorRGB);
    chars.add(character);
  }
}
