package com.csdn.design.patterns.theory.combat.mvc.service;

import com.csdn.design.patterns.theory.combat.mvc.contants.TransactionType;
import com.csdn.design.patterns.theory.combat.mvc.dao.VirtualWalletRepository;
import com.csdn.design.patterns.theory.combat.mvc.dao.VirtualWalletTransactionRepository;
import com.csdn.design.patterns.theory.combat.mvc.entity.VirtualWalletBo;
import com.csdn.design.patterns.theory.combat.mvc.entity.VirtualWalletEntity;
import com.csdn.design.patterns.theory.combat.mvc.entity.VirtualWalletTransactionEntity;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:32
 */
@Service
public class VirtualWalletService {

  @Autowired
  private VirtualWalletRepository walletRepository;

  @Autowired
  private VirtualWalletTransactionRepository transactionRepository;

  public VirtualWalletBo getVirtualWallet(Long walletId) {
    VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
    return VirtualWalletEntity.convert(walletEntity);
  }

  public BigDecimal getBalance(Long walletId) {
    return walletRepository.getBalance(walletId);
  }

  @Transactional(rollbackFor = Exception.class)
  public void debit(Long walletId, BigDecimal amount) {
    // 获取钱包余额
    VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
    BigDecimal balance = walletEntity.getBalance();
    if (balance.compareTo(amount) < 0) {
      throw new RuntimeException("...");
    }
    // 封装交易对象
    VirtualWalletTransactionEntity transactionEntity = VirtualWalletTransactionEntity.builder()
        .amount(amount)
        .createTime(System.currentTimeMillis()).fromWalletId(walletId).type(
            TransactionType.DEBIT.name()).build();
    // 保存交易
    transactionRepository.saveTranscation(transactionEntity);
    // 更新余额
    walletRepository.updateBalance(walletId, balance.subtract(amount));
  }

  @Transactional(rollbackFor = Exception.class)
  public void credit(Long walletId, BigDecimal amount) {
    // 封装交易对象
    VirtualWalletTransactionEntity transactionEntity = VirtualWalletTransactionEntity.builder()
        .amount(amount)
        .createTime(System.currentTimeMillis()).fromWalletId(walletId).type(
            TransactionType.CREDIT.name()).build();
    // 保存交易
    transactionRepository.saveTranscation(transactionEntity);
    VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
    // 更新余额
    walletRepository.updateBalance(walletId, walletEntity.getBalance().add(amount));
  }

  @Transactional(rollbackFor = Exception.class)
  public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
    // 封装交易对象
    VirtualWalletTransactionEntity transactionEntity = VirtualWalletTransactionEntity.builder()
        .amount(amount)
        .createTime(System.currentTimeMillis()).fromWalletId(fromWalletId).toWalletId(toWalletId)
        .type(
            TransactionType.CREDIT.name()).build();
    // 保存交易
    transactionRepository.saveTranscation(transactionEntity);
    debit(fromWalletId, amount);
    credit(toWalletId, amount);
  }

}
