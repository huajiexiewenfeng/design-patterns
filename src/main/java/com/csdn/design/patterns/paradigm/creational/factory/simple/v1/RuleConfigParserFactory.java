package com.csdn.design.patterns.paradigm.creational.factory.simple.v1;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.InvalidRuleConfigException;
import com.csdn.design.patterns.paradigm.creational.factory.simple.JsonRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.PropertiesRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.XmlRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.YamlRuleConfigParser;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:14
 */
public class RuleConfigParserFactory {

  public static IRuleConfigParser createParser(String configFormat) {
    IRuleConfigParser parser = null;
    if ("json".equalsIgnoreCase(configFormat)) {
      parser = new JsonRuleConfigParser();
    } else if ("xml".equalsIgnoreCase(configFormat)) {
      parser = new XmlRuleConfigParser();
    } else if ("yaml".equalsIgnoreCase(configFormat)) {
      parser = new YamlRuleConfigParser();
    } else if ("properties".equalsIgnoreCase(configFormat)) {
      parser = new PropertiesRuleConfigParser();
    }
    return parser;
  }

}
