package com.csdn.design.patterns.project.darklaunch.rule;

import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/23 13:51
 */
public class DarkRuleConfig {

  private List<DarkFeatureConfig> features;

  public List<DarkFeatureConfig> getFeatures() {
    return features;
  }

  public void setFeatures(
      List<DarkFeatureConfig> features) {
    this.features = features;
  }
}
