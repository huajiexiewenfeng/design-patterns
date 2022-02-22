package com.csdn.design.patterns.project.ratelimiter.parser;

import com.alibaba.fastjson.JSON;
import com.csdn.design.patterns.project.ratelimiter.rule.RuleConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:50
 */
public class JsonRuleConfigParser implements RuleConfigParser {

  @Override
  public RuleConfig parse(String configText) {
    return parse(new ByteArrayInputStream(configText.getBytes()));
  }

  @Override
  public RuleConfig parse(InputStream in) {
    try {
      return JSON.parseObject(in, RuleConfig.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
