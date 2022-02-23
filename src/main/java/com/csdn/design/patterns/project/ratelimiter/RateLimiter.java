package com.csdn.design.patterns.project.ratelimiter;

import com.csdn.design.patterns.project.ratelimiter.alg.FixedTimeWinRateLimitAlg;
import com.csdn.design.patterns.project.ratelimiter.alg.RateLimitAlg;
import com.csdn.design.patterns.project.ratelimiter.datasource.FileRuleConfigSource;
import com.csdn.design.patterns.project.ratelimiter.datasource.RuleConfigSource;
import com.csdn.design.patterns.project.ratelimiter.rule.ApiLimit;
import com.csdn.design.patterns.project.ratelimiter.rule.RuleConfig;
import com.csdn.design.patterns.project.ratelimiter.rule.TrieRateLimitRule;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 15:31
 */
public class RateLimiter {

  private static final Logger log = LoggerFactory.getLogger(RateLimiter.class);
  // 为每个 api 在内存中存储限流计数器
  private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
  private TrieRateLimitRule rule;

  public RateLimiter() {
    RuleConfigSource configSource = new FileRuleConfigSource();
    RuleConfig ruleConfig = configSource.load();
    this.rule = new TrieRateLimitRule(ruleConfig);
  }

  public boolean limit(String appId, String url) {
    ApiLimit apiLimit = rule.getLimit(appId, url);
    if (apiLimit == null) {
      return true;
    }
    // 获取 api 对应在内存中的限流计数器
    String counterKey = appId + ":" + apiLimit.getApi();
    RateLimitAlg rateLimitCounter = counters.get(counterKey);
    if (rateLimitCounter == null) {
      RateLimitAlg newRateLimitCounter = new FixedTimeWinRateLimitAlg(apiLimit.getLimit(),
          apiLimit.getUnit());
      rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
      if (rateLimitCounter == null) {
        rateLimitCounter = newRateLimitCounter;
      }
    }
    return rateLimitCounter.tryAcquire();
  }
}
