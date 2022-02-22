package com.csdn.design.patterns.project.ratelimiter.rule;

/**
 * 单词查找树
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/21 16:12
 */
public class TrieRateLimitRule implements RateLimitRule {

  private RuleConfig ruleConfig;

  public TrieRateLimitRule(RuleConfig ruleConfig) {
    this.ruleConfig = ruleConfig;
  }

  public ApiLimit getLimit(String appId, String api) {
    return null;
  }
}
