package com.csdn.design.patterns.theory.combat.mvc.dao;

import com.csdn.design.patterns.theory.combat.mvc.entity.VirtualWalletEntity;
import java.math.BigDecimal;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:48
 */
public interface VirtualWalletRepository {

  VirtualWalletEntity getWalletEntity(Long walletId);

  BigDecimal getBalance(Long walletId);

  void updateBalance(Long walletId, BigDecimal subtract);
}
