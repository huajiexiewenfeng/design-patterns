package com.csdn.design.patterns.theory.oop;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 封装示例
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/9 10:16
 */
public class Wallet {

  private final String id;
  private final long createTime;
  private BigDecimal balance;
  private long balanceLastModifiedTime;

  public Wallet() {
    this.id = UUID.randomUUID().toString();
    this.createTime = System.currentTimeMillis();
    this.balance = BigDecimal.ZERO;
    this.balanceLastModifiedTime = System.currentTimeMillis();
  }

  public String getId() {
    return id;
  }

  public long getCreateTime() {
    return createTime;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public long getBalanceLastModifiedTime() {
    return balanceLastModifiedTime;
  }

  public void increaseBalance(BigDecimal increasedAmount) {
    if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("增加金额不能小于0");
    }
    this.balance = this.balance.add(increasedAmount);
    this.balanceLastModifiedTime = System.currentTimeMillis();
  }

  public void decreaseBalance(BigDecimal decreasedAmount) {
    if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("减少金额不能小于0");
    }
    if (decreasedAmount.compareTo(this.balance) > 0) {
      throw new RuntimeException("减少金额不能大于当前余额");
    }
    this.balance = this.balance.subtract(decreasedAmount);
    this.balanceLastModifiedTime = System.currentTimeMillis();
  }
}
