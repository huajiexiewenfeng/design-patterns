package com.csdn.design.patterns.thinking.principle.hotupdate;

import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:20
 */
public interface Viewer {

  String outputInPlainText();

  Map<String, String> output();

}
