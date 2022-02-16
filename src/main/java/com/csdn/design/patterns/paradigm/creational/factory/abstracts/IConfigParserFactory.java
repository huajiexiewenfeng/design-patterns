package com.csdn.design.patterns.paradigm.creational.factory.abstracts;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:32
 */
public interface IConfigParserFactory {

  IRuleConfigParser createRuleParser();

  ISystemConfigParser createSystemParser();
}
