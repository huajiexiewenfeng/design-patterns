package com.csdn.design.patterns.project.darklaunch.datasource;

import com.csdn.design.patterns.project.darklaunch.rule.DarkRuleConfig;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:56
 */
public interface RuleConfigSource {

  DarkRuleConfig load();
}
