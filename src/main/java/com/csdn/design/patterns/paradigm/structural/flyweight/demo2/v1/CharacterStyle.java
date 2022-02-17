package com.csdn.design.patterns.paradigm.structural.flyweight.demo2.v1;

import com.csdn.design.patterns.paradigm.structural.flyweight.demo2.Font;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:07
 */
public class CharacterStyle {

  private Font font;
  private int size;
  private int colorRGB;

  public CharacterStyle(Font font, int size, int colorRGB) {
    this.font = font;
    this.size = size;
    this.colorRGB = colorRGB;
  }

  @Override
  public boolean equals(Object o) {
    CharacterStyle otherStyle = (CharacterStyle) o;
    return font.equals(otherStyle.font) && size == otherStyle.size
        && colorRGB == otherStyle.colorRGB;
  }
}
