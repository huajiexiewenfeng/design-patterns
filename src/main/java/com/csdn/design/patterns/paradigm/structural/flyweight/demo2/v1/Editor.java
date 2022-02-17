package com.csdn.design.patterns.paradigm.structural.flyweight.demo2.v1;

import com.csdn.design.patterns.paradigm.structural.flyweight.demo2.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:12
 */
public class Editor {

  private List<Character> chars = new ArrayList<>();

  public void appendCharacter(char c, Font font, int size, int colorRGB) {
    Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
    chars.add(character);
  }
}
