package com.csdn.design.patterns.paradigm.creational.factory.simple.v1;

import com.csdn.design.patterns.paradigm.creational.factory.simple.IRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.InvalidRuleConfigException;
import com.csdn.design.patterns.paradigm.creational.factory.simple.JsonRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.PropertiesRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.RuleConfig;
import com.csdn.design.patterns.paradigm.creational.factory.simple.XmlRuleConfigParser;
import com.csdn.design.patterns.paradigm.creational.factory.simple.YamlRuleConfigParser;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:10
 */

public class RuleConfigSource {

  public RuleConfig load(String ruleConfigFilePath) {
    String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
    IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
    if (parser == null) {
      throw new InvalidRuleConfigException(
          "Rule config file format is not supported: " + ruleConfigFilePath);
    }
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