package com.csdn.design.patterns.project.ratelimiter.parser;

import com.csdn.design.patterns.project.ratelimiter.rule.RuleConfig;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.yaml.snakeyaml.Yaml;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:50
 */
public class YamlRuleConfigParser implements RuleConfigParser {

  @Override
  public RuleConfig parse(String configText) {
    return parse(new ByteArrayInputStream(configText.getBytes()));
  }

  @Override
  public RuleConfig parse(InputStream in) {
    Yaml yaml = new Yaml();
    return yaml.loadAs(in, RuleConfig.class);
  }
}
