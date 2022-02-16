package com.csdn.design.patterns.paradigm.creational.builder;

import org.springframework.util.StringUtils;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 14:58
 */
public class ResourcePoolConfig {

  private String name;
  private int maxTotal;
  private int maxIdle;
  private int minIdle;

  public ResourcePoolConfig(Builder builder) {
    this.name = builder.name;
    this.maxTotal = builder.maxTotal;
    this.maxIdle = builder.maxIdle;
    this.minIdle = builder.minIdle;
  }

  public static class Builder {

    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig build() {
      // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
      if (StringUtils.isEmpty(name)) {
        throw new IllegalArgumentException("...");
      }
      if (maxIdle > maxTotal) {
        throw new IllegalArgumentException("...");
      }
      if (minIdle > maxTotal || minIdle > maxIdle) {
        throw new IllegalArgumentException("...");
      }
      return new ResourcePoolConfig(this);
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setMaxTotal(int maxTotal) {
      this.maxTotal = maxTotal;
      return this;
    }

    public Builder setMaxIdle(int maxIdle) {
      this.maxIdle = maxIdle;
      return this;
    }

    public Builder setMinIdle(int minIdle) {
      this.minIdle = minIdle;
      return this;
    }
  }

  public static void main(String[] args) {
    ResourcePoolConfig config = new Builder().setName("dbtest").setMaxIdle(6).setMaxTotal(10)
        .setMinIdle(3)
        .build();
  }
}
