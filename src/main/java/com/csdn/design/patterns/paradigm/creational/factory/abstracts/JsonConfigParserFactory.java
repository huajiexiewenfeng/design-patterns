package com.csdn.design.patterns.paradigm.creational.factory.abstracts;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:33
 */
public class JsonConfigParserFactory implements IConfigParserFactory{

  @Override
  public IRuleConfigParser createRuleParser() {
    return null;
  }

  @Override
  public ISystemConfigParser createSystemParser() {
    return null;
  }
}
