package com.csdn.design.patterns.paradigm.creational.factory.simple.v1;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.JsonRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.PropertiesRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.XmlRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.YamlRuleConfigParser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ObjectUtils;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:19
 */
public class RuleConfigParserFactoryV2 {

  private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

  static {
    cachedParsers.put("json", new JsonRuleConfigParser());
    cachedParsers.put("xml", new XmlRuleConfigParser());
    cachedParsers.put("yaml", new YamlRuleConfigParser());
    cachedParsers.put("properties", new PropertiesRuleConfigParser());
  }

  public static IRuleConfigParser createParser(String configFormat) {
    if (ObjectUtils.isEmpty(configFormat)) {
      return null;
    }
    return cachedParsers.get(configFormat);
  }

}
