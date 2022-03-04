package com.csdn.design.patterns.project.darklaunch.rule;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/24 11:18
 */
public class DarkFeatureConfig {

  private String key;
  private boolean enabled;
  private String rule;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getRule() {
    return rule;
  }

  public void setRule(String rule) {
    this.rule = rule;
  }
}
