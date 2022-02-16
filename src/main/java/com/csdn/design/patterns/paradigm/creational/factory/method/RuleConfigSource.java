package com.csdn.design.patterns.paradigm.creational.factory.method;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.InvalidRuleConfigException;
import com.csdn.design.patterns.paradigm.creational.factory.simple.RuleConfig;

public class RuleConfigSource {

  public RuleConfig load(String ruleConfigFilePath) {
    String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

    IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap
        .getParserFactory(ruleConfigFileExtension);
    if (parserFactory == null) {
      throw new InvalidRuleConfigException(
          "Rule config file format is not supported: " + ruleConfigFilePath);
    }
    IRuleConfigParser parser = parserFactory.createParser();

    String configText = "";
    //从ruleConfigFilePath文件中读取配置文本到configText中
    RuleConfig ruleConfig = parser.parse(configText);
    return ruleConfig;
  }

  private String getFileExtension(String filePath) {
    //...解析文件名获取扩展名，比如rule.json，返回json
    return "json";
  }
}

