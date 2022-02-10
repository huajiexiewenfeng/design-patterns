package com.csdn.design.patterns.theory.combat.mvc.entity;

import com.csdn.design.patterns.theory.combat.ddd.domain.VirtualWallet;
import java.math.BigDecimal;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:52
 */
public class VirtualWalletEntity {

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

  public static VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
    return VirtualWalletBo.builder()
        .balance(walletEntity.getBalance())
        .createTime(walletEntity.getCreateTime())
        .id(walletEntity.getId())
        .build();
  }

  public static VirtualWallet convertToVirtualWallet(VirtualWalletEntity walletEntity) {
    return VirtualWallet.builder()
        .balance(walletEntity.getBalance())
        .createTime(walletEntity.getCreateTime())
        .id(walletEntity.getId())
        .build();
  }
}
