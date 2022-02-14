package com.csdn.design.patterns.thinking.specifications.test.transaction;

import java.util.UUID;
import javax.transaction.InvalidTransactionException;

public class Transaction {

  private String id;
  private Long buyerId;
  private Long sellerId;
  private Long productId;
  private Long orderId;
  private Long createTimestamp;
  private Double amount;
  private STATUS status;
  private String walletTransactionId;
  private static final long days = 14 * 24 * 60 * 60 * 1000L;
  private WalletRpcService walletRpcService;
  private TransactionLock lock;

  public void setWalletRpcService(
      WalletRpcService walletRpcService) {
    this.walletRpcService = walletRpcService;
  }

  public void setLock(
      TransactionLock lock) {
    this.lock = lock;
  }

  // ...get() methods...

  protected void fillTransactionId(String preAssignedId) {
    if (preAssignedId != null && !preAssignedId.isEmpty()) {
      this.id = preAssignedId;
    } else {
      this.id = UUID.randomUUID().toString();
    }
    if (!this.id.startsWith("t_")) {
      this.id = "t_" + preAssignedId;
    }
  }

  public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId,
      Long orderId) {
    fillTransactionId(preAssignedId);
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.orderId = orderId;
    this.status = STATUS.TO_BE_EXECUTED;
    this.createTimestamp = System.currentTimeMillis();
  }

  public boolean execute() throws InvalidTransactionException {
    if ((buyerId == null || (sellerId == null || amount < 0.0))) {
      throw new InvalidTransactionException("...");
    }
    if (status == STATUS.EXECUTED) {
      return true;
    }
    boolean isLocked = false;
    try {
      isLocked = lock.lock(id);
      if (!isLocked) {
        return false; // 锁定未成功，返回false，job兜底执行
      }
      if (status == STATUS.EXECUTED) {
        return true; // double check
      }
      if (isExpired()) {
        this.status = STATUS.EXPIRED;
        return false;
      }
      long executionInvokedTimestamp = System.currentTimeMillis();
      if (executionInvokedTimestamp - createTimestamp > days) {
        this.status = STATUS.EXPIRED;
        return false;
      }
      String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
      if (walletTransactionId != null) {
        this.walletTransactionId = walletTransactionId;
        this.status = STATUS.EXECUTED;
        return true;
      } else {
        this.status = STATUS.FAILED;
        return false;
      }
    } finally {
      if (isLocked) {
        lock.unlock(id);
      }
    }
  }

  protected boolean isExpired() {
    long executionInvokedTimestamp = System.currentTimeMillis();
    return executionInvokedTimestamp - createTimestamp > days;
  }
}