package com.csdn.design.patterns.theory.combat.ddd.service;

import com.csdn.design.patterns.theory.combat.ddd.domain.VirtualWallet;
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
 * @Date: 2022/2/10 11:26
 */
@Service
public class VirtualWalletService {

  @Autowired
  private VirtualWalletRepository walletRepository;

  @Autowired
  private VirtualWalletTransactionRepository transactionRepository;

  public VirtualWallet getVirtualWallet(Long walletId) {
    VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
    return VirtualWalletEntity.convertToVirtualWallet(walletEntity);
  }

  public BigDecimal getBalance(Long walletId) {
    return walletRepository.getBalance(walletId);
  }

  @Transactional(rollbackFor = Exception.class)
  public void debit(Long walletId, BigDecimal amount) {
    // 获取钱包
    VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
    VirtualWallet wallet = VirtualWalletEntity.convertToVirtualWallet(walletEntity);
    wallet.debit(amount);
    // 封装交易对象
    VirtualWalletTransactionEntity transactionEntity = VirtualWalletTransactionEntity.builder()
        .amount(amount)
        .createTime(System.currentTimeMillis()).fromWalletId(walletId).type(
            TransactionType.DEBIT.name()).build();
    // 保存交易
    transactionRepository.saveTranscation(transactionEntity);
    // 更新余额
    walletRepository.updateBalance(walletId, wallet.balance());
  }

  @Transactional(rollbackFor = Exception.class)
  public void credit(Long walletId, BigDecimal amount) {
    // 获取钱包
    VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
    VirtualWallet wallet = VirtualWalletEntity.convertToVirtualWallet(walletEntity);
    wallet.credit(amount);
    // 封装交易对象
    VirtualWalletTransactionEntity transactionEntity = VirtualWalletTransactionEntity.builder()
        .amount(amount)
        .createTime(System.currentTimeMillis()).fromWalletId(walletId).type(
            TransactionType.CREDIT.name()).build();
    // 保存交易
    transactionRepository.saveTranscation(transactionEntity);
    // 更新余额
    walletRepository.updateBalance(walletId, wallet.balance());
  }

  /**
   * 与贫血模型的代码一样
   *
   * @param fromWalletId
   * @param toWalletId
   * @param amount
   */
  @Transactional(rollbackFor = Exception.class)
  public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
    // 封装交易对象
    VirtualWalletTransactionEntity transactionEntity = VirtualWalletTransactionEntity.builder()
        .amount(amount)
        .createTime(System.currentTimeMillis()).fromWalletId(fromWalletId).toWalletId(toWalletId)
        .type(
            TransactionType.TRANSFER.name()).build();
    // 保存交易
    transactionRepository.saveTranscation(transactionEntity);
    debit(fromWalletId, amount);
    credit(toWalletId, amount);
  }

}
