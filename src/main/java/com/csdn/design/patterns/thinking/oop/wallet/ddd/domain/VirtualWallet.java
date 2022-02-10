package com.csdn.design.patterns.thinking.oop.wallet.ddd.domain;

import java.math.BigDecimal;
import lombok.Builder;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:30
 */
@Builder
public class VirtualWallet {

  private Long id;
  private Long createTime = System.currentTimeMillis();
  private BigDecimal balance = BigDecimal.ZERO;

  public VirtualWallet(Long preAllocatedId) {
    this.id = preAllocatedId;
  }

  public BigDecimal balance() {
    return balance;
  }

  /**
   * 出账
   */
  public void debit(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("减少金额不能小于0");
    }
    if (amount.compareTo(this.balance) > 0) {
      throw new RuntimeException("减少金额不能大于当前余额");
    }
    this.balance = this.balance.subtract(amount);
  }

  /**
   * 入账
   *
   * @param amount
   */
  public void credit(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new RuntimeException("增加金额不能小于0");
    }
    this.balance = this.balance.add(amount);
  }

}
