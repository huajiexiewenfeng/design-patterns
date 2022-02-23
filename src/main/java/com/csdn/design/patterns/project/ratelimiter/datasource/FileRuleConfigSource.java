package com.csdn.design.patterns.project.ratelimiter.datasource;

import com.csdn.design.patterns.project.ratelimiter.parser.JsonRuleConfigParser;
import com.csdn.design.patterns.project.ratelimiter.parser.RuleConfigParser;
import com.csdn.design.patterns.project.ratelimiter.parser.YamlRuleConfigParser;
import com.csdn.design.patterns.project.ratelimiter.rule.RuleConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/22 16:55
 */
public class FileRuleConfigSource implements RuleConfigSource {

  private static final Logger log = LoggerFactory.getLogger(FileRuleConfigSource.class);
  public static final String API_LIMIT_CONFIG_NAME = "ratelimiter-rule";
  public static final String YAML_EXTENSION = "yaml";
  public static final String YML_EXTENSION = "yml";
  public static final String JSON_EXTENSION = "json";

  private static final Map<String, RuleConfigParser> PARSER_MAP = new HashMap<>();
  private static final String[] SUPPORT_EXTENSIONS = new String[]{YAML_EXTENSION, YML_EXTENSION,
      JSON_EXTENSION};

  static {
    PARSER_MAP.put(YAML_EXTENSION, new YamlRuleConfigParser());
    PARSER_MAP.put(YML_EXTENSION, new YamlRuleConfigParser());
    PARSER_MAP.put(JSON_EXTENSION, new JsonRuleConfigParser());
  }

  @Override
  public RuleConfig load() {
    for (String extension : SUPPORT_EXTENSIONS) {
      InputStream in = null;
      try {
        in = this.getClass().getResourceAsStream(getFileNameByExt(extension));
        if (null != in) {
          RuleConfigParser parser = PARSER_MAP.get(extension);
          return parser.parse(in);
        }
      } finally {
        if (in != null) {
          try {
            in.close();
          } catch (IOException e) {
            log.error("close file error:{}", e);
          }
        }
      }
    }
    return null;
  }

  private String getFileNameByExt(String extension) {
    return API_LIMIT_CONFIG_NAME + "." + extension;
  }
}
