package com.csdn.design.patterns.paradigm.creational.factory.simple;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:11
 */
public interface IRuleConfigParser {

  RuleConfig parse(String configText);
}
