package com.csdn.design.patterns.thinking.oop.wallet.mvc.entity;

import java.math.BigDecimal;
import lombok.Builder;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:30
 */
@Builder
public class VirtualWalletBo {

  private Long id;
  private Long createTime;
  private BigDecimal balance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
