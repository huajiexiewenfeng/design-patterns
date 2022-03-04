package com.csdn.design.patterns.project.darklaunch.parser;

import com.csdn.design.patterns.project.darklaunch.rule.DarkRuleConfig;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:50
 */
public class YamlRuleConfigParser implements RuleConfigParser {

  @Override
  public DarkRuleConfig parse(String configText) {
    return parse(new ByteArrayInputStream(configText.getBytes()));
  }

  @Override
  public DarkRuleConfig parse(InputStream in) {
    Yaml yaml = new Yaml();
    return yaml.loadAs(in, DarkRuleConfig.class);
  }
}
