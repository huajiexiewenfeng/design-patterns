package com.csdn.design.patterns.paradigm.structural.bridge;

import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 16:47
 */
public class TelephoneMsgSender implements MsgSender {

  private List<String> telephones;

  public TelephoneMsgSender(List<String> telephones) {
    this.telephones = telephones;
  }

  @Override
  public void send(String message) {
    //...
  }
}
