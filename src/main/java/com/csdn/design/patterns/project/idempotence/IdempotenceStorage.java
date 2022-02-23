package com.csdn.design.patterns.project.idempotence;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/23 10:51
 */
public interface IdempotenceStorage {

  boolean saveIfAbsent(String idempotenceId);

  void delete(String idempotenceId);
}
