package com.csdn.design.patterns.project.ratelimiter;

import com.csdn.design.patterns.project.ratelimiter.rule.ApiLimit;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/21 16:20
 */
public class AppRuleConfig {

  private String appId;
  private List<ApiLimit> limits;

  public AppRuleConfig() {
  }

  public AppRuleConfig(String appId,
      List<ApiLimit> limits) {
    this.appId = appId;
    this.limits = limits;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public List<ApiLimit> getLimits() {
    return limits;
  }

  public void setLimits(List<ApiLimit> limits) {
    this.limits = limits;
  }
}
