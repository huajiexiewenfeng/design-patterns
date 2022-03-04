package com.csdn.design.patterns.project.darklaunch.parser;

import com.csdn.design.patterns.project.darklaunch.rule.DarkRuleConfig;
import java.io.InputStream;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:50
 */
public interface RuleConfigParser {

  DarkRuleConfig parse(String configText);

  DarkRuleConfig parse(InputStream in);
}
