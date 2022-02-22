package com.csdn.design.patterns.project.ratelimiter.rule;

import com.csdn.design.patterns.project.ratelimiter.AppRuleConfig;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 16:16
 */
public class RuleConfig {

  private List<AppRuleConfig> configs;

  public List<AppRuleConfig> getConfigs() {
    return configs;
  }

  public void setConfigs(List<AppRuleConfig> configs) {
    this.configs = configs;
  }
}
