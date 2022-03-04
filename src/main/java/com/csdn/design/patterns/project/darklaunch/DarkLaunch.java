package com.csdn.design.patterns.project.darklaunch;

import com.csdn.design.patterns.project.darklaunch.datasource.FileRuleConfigSource;
import com.csdn.design.patterns.project.darklaunch.datasource.RuleConfigSource;
import com.csdn.design.patterns.project.darklaunch.rule.DarkFeatureConfig;
import com.csdn.design.patterns.project.darklaunch.rule.DarkRule;
import com.csdn.design.patterns.project.darklaunch.rule.DarkRuleConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 灰度发布，最顶层的入口类
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/23 13:50
 */
public class DarkLaunch {

  private static final Logger log = LoggerFactory.getLogger(DarkLaunch.class);
  /**
   * in seconds
   */
  private static final int DEFAULT_RULE_UPDATE_TIME_INTERVAL = 60;

  private DarkRule rule;
  private ScheduledExecutorService executor;

  public DarkLaunch() {
    this(DEFAULT_RULE_UPDATE_TIME_INTERVAL);
  }

  public DarkLaunch(int ruleUpdateTimeInterval) {
    //读取灰度规则配置文件
    loadRule();
    // 定时更新
    this.executor = Executors.newSingleThreadScheduledExecutor();
    this.executor
        .scheduleAtFixedRate(this::loadRule, ruleUpdateTimeInterval, ruleUpdateTimeInterval,
            TimeUnit.SECONDS);
  }

  private void loadRule() {
    RuleConfigSource parser = new FileRuleConfigSource();
    DarkRuleConfig ruleConfig = parser.load();
    if (ruleConfig == null) {
      throw new RuntimeException("Can not load dark rule.");
    }
    /**
     * 更新规则并非直接在this.rule上进行,而是通过创建一个新的 DarkRule 对象赋值给 this.rule
     * 来不免更新规则和规则查询并发冲突问题
     */
//    DarkRule newRule = new DarkRule(ruleConfig);
//    this.rule = newRule;
    // 修改：单独更新从配置文件中得到的灰度规则，不覆盖编程实现的灰度规则
    Map<String, IDarkFeature> darkFeatures = new HashMap<>();
    List<DarkFeatureConfig> features = ruleConfig.getFeatures();
    for (DarkFeatureConfig darkFeatureConfig : features) {
      darkFeatures.put(darkFeatureConfig.getKey(), new DarkFeature(darkFeatureConfig));
    }
    this.rule.setDarkFeatures(darkFeatures);
  }

  // 新增：添加编程实现的灰度规则的接口
  public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
    this.rule.addProgrammedDarkFeature(featureKey, darkFeature);
  }

  public IDarkFeature getDarkFeature(String featureKey) {
    return this.rule.getDarkFeature(featureKey);
  }
}
