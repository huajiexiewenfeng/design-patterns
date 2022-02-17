package com.csdn.design.patterns.paradigm.structural.flyweight.demo2.v1;

import com.csdn.design.patterns.paradigm.structural.flyweight.demo2.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/17 14:08
 */
public class CharacterStyleFactory {

  private static final List<CharacterStyle> styles = new ArrayList<>();

  public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
    CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
    for (CharacterStyle style : styles) {
      if (style.equals(newStyle)) {
        return style;
      }
    }
    styles.add(newStyle);
    return newStyle;
  }

}
