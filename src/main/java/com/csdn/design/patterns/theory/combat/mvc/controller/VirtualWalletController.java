package com.csdn.design.patterns.theory.combat.mvc.controller;

import com.csdn.design.patterns.theory.combat.mvc.service.VirtualWalletService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:28
 */
@RestController("/virtualWallet")
public class VirtualWalletController {

  @Autowired
  private VirtualWalletService virtualWalletService;

  /**
   * 查询余额
   *
   * @param walletId
   * @return
   */
  @GetMapping("/getBalance")
  public BigDecimal getBalance(Long walletId) {
    return virtualWalletService.getBalance(walletId);
  }

  /**
   * 出账
   */
  @PostMapping("/debit")
  public void debit(Long walletId, BigDecimal amount) {
    virtualWalletService.debit(walletId, amount);
  }

  /**
   * 入账
   */
  @PostMapping("/credit")
  public void credit(Long walletId, BigDecimal amount) {
    virtualWalletService.credit(walletId, amount);
  }

  /**
   * 转账
   */
  @PostMapping("/transfer")
  public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
    virtualWalletService.transfer(fromWalletId,toWalletId, amount);
  }


}
