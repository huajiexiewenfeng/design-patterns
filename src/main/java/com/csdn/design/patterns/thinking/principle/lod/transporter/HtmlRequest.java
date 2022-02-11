package com.csdn.design.patterns.thinking.principle.lod.transporter;

import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:27
 */
@Data
public class HtmlRequest {

  private String address;
  private String content;
  private String url;

  public HtmlRequest(String url) {
    this.url = url;
  }
}
