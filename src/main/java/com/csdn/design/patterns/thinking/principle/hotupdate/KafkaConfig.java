package com.csdn.design.patterns.thinking.principle.hotupdate;

import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:07
 */
public class KafkaConfig implements Updater, Viewer {

  @Override
  public void update() {

  }

  @Override
  public String outputInPlainText() {
    return null;
  }

  @Override
  public Map<String, String> output() {
    return null;
  }
}
