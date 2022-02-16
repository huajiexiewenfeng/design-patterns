package com.csdn.design.patterns.thinking.principle.metrics.v2;

import com.csdn.design.patterns.thinking.principle.metrics.v1.EmailSender;
import com.csdn.design.patterns.thinking.principle.metrics.v1.MetricsStorage;
import com.csdn.design.patterns.thinking.principle.metrics.v1.RequestStat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 16:57
 */
public class EmailViewer implements StatViewer {

  private EmailSender emailSender;
  private List<String> toAddress = new ArrayList<>();

  public EmailViewer() {
    this.emailSender = new EmailSender();
  }

  public EmailViewer(EmailSender emailSender) {
    this.emailSender = emailSender;
  }

  public EmailViewer(List<String> emailToAddresses) {
    this.emailSender = new EmailSender();
    this.toAddress = emailToAddresses;
  }

  public void addToAddress(String address) {
    this.toAddress.add(address);
  }

  @Override
  public void output(Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMillis) {
    // format the requestStats to HTML style.
    // send it to email toAddresses.
  }
}
