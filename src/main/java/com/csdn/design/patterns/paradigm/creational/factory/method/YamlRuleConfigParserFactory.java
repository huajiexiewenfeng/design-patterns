package com.csdn.design.patterns.paradigm.creational.factory.method;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new YamlRuleConfigParser();
  }
}