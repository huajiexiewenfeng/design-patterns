package com.csdn.design.patterns.thinking.specifications.test.transaction;

import javax.transaction.InvalidTransactionException;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/14 17:04
 */
public class Test {

  public void testExecute() throws InvalidTransactionException {
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    Long orderId = 456L;
    Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
    boolean executedResult = transaction.execute();
  }

  /**
   * 解决 WalletRpcService 问题
   *
   * @throws InvalidTransactionException
   */
  public void testExecuteV1() throws InvalidTransactionException {
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    Long orderId = 456L;
    Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
    transaction.setWalletRpcService(new MockWalletRpcServiceOne());
    boolean executedResult = transaction.execute();
  }

  /**
   * 解决 TransactionLock 问题
   *
   * @throws InvalidTransactionException
   */
  public void testExecuteV2() throws InvalidTransactionException {
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    Long orderId = 456L;

    TransactionLock mockLock = new TransactionLock() {
      @Override
      public boolean lock(String id) {
        return true;
      }

      @Override
      public void unlock(String id) {

      }
    };

    Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
    transaction.setWalletRpcService(new MockWalletRpcServiceOne());
    transaction.setLock(mockLock);
    boolean executedResult = transaction.execute();
  }

  /**
   * 过期测试
   *
   * @throws InvalidTransactionException
   */
  public void testExecute_with_TransactionIsExpired() throws InvalidTransactionException {
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    Long orderId = 456L;

    Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId) {
      @Override
      protected boolean isExpired() {
        return true;
      }
    };

    boolean executedResult = transaction.execute();
  }

}
