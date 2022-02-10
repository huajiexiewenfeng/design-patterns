package com.csdn.design.patterns.theory.combat.ddd.domain;

import java.math.BigDecimal;
import lombok.Builder;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/10 10:30
 */
@Builder
public class VirtualWallet {

  private Long id;
  private Long createTime = System.currentTimeMillis();
  private BigDecimal balance = BigDecimal.ZERO;

  
}
