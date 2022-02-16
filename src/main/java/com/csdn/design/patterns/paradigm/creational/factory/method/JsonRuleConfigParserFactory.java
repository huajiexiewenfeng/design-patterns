package com.csdn.design.patterns.paradigm.creational.factory.method;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {

  @Override
  public IRuleConfigParser createParser() {
    return new JsonRuleConfigParser();
  }
}