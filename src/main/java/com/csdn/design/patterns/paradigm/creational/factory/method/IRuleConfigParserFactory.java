package com.csdn.design.patterns.paradigm.creational.factory.method;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:27
 */
public interface IRuleConfigParserFactory {
  IRuleConfigParser createParser();
}
