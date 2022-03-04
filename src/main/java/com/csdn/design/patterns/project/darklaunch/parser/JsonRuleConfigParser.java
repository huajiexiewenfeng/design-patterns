package com.csdn.design.patterns.project.darklaunch.parser;

import com.alibaba.fastjson.JSON;
import com.csdn.design.patterns.project.darklaunch.rule.DarkRuleConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:50
 */
public class JsonRuleConfigParser implements RuleConfigParser {

  @Override
  public DarkRuleConfig parse(String configText) {
    return parse(new ByteArrayInputStream(configText.getBytes()));
  }

  @Override
  public DarkRuleConfig parse(InputStream in) {
    try {
      DarkRuleConfig darkRule = JSON.parseObject(in, DarkRuleConfig.class);
      return darkRule;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
