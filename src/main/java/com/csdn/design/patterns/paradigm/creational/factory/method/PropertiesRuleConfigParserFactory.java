package com.csdn.design.patterns.paradigm.creational.factory.method;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.PropertiesRuleConfigParser;

public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public IRuleConfigParser createParser() {
    return new PropertiesRuleConfigParser();
  }
}