package com.csdn.design.patterns.project.ratelimiter.parser;

import com.csdn.design.patterns.project.ratelimiter.rule.RuleConfig;
import java.io.InputStream;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:50
 */
public interface RuleConfigParser {

  RuleConfig parse(String configText);

  RuleConfig parse(InputStream in);
}
