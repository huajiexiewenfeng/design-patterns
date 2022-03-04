package com.csdn.design.patterns.project.darklaunch.rule;

import com.csdn.design.patterns.project.darklaunch.IDarkFeature;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ObjectUtils;

/**
 * 灰度规则
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/23 13:50
 */
public class DarkRule {

  /**
   * 从配置文件中获取灰度规则
   */
  private Map<String, IDarkFeature> darkFeatures = new HashMap<>();

  /**
   * 编程方式实现灰度规则
   */
  private Map<String, IDarkFeature> programmedDarkFeatures = new HashMap<>();

  public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
    programmedDarkFeatures.put(featureKey, darkFeature);
  }

  public void setDarkFeatures(Map<String, IDarkFeature> darkFeatures) {
    this.darkFeatures = darkFeatures;
  }

//  public DarkRule(DarkRuleConfig ruleConfig) {
//    for (DarkFeatureConfig darkFeatureConfig : ruleConfig.getFeatures()) {
//      darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
//    }
//  }

  public IDarkFeature getDarkFeature(String featureKey) {
    IDarkFeature darkFeature = programmedDarkFeatures.get(featureKey);
    return ObjectUtils.isEmpty(darkFeature) ? darkFeatures.get(featureKey) : darkFeature;
  }
}
