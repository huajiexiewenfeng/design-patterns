package com.csdn.design.patterns.project.ratelimiter.datsource;

import com.csdn.design.patterns.project.ratelimiter.rule.RuleConfig;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:56
 */
public interface RuleConfigSource {

  RuleConfig load();
}
