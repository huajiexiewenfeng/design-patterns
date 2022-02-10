package com.csdn.design.patterns.theory.combat.mvc.dao;

import com.csdn.design.patterns.theory.combat.mvc.entity.VirtualWalletTransactionEntity;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:48
 */
public interface VirtualWalletTransactionRepository {

  void saveTranscation(VirtualWalletTransactionEntity transactionEntity);
}
