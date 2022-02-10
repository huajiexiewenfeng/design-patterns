package com.csdn.design.patterns.thinking.oop.wallet.mvc.entity;

import java.math.BigDecimal;
import lombok.Builder;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 11:00
 */
@Builder
public class VirtualWalletTransactionEntity {

  private BigDecimal amount;
  private Long createTime;
  private String type;
  private Long fromWalletId;
  private Long toWalletId;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getFromWalletId() {
    return fromWalletId;
  }

  public void setFromWalletId(Long fromWalletId) {
    this.fromWalletId = fromWalletId;
  }

  public Long getToWalletId() {
    return toWalletId;
  }

  public void setToWalletId(Long toWalletId) {
    this.toWalletId = toWalletId;
  }
}
