package com.csdn.design.patterns.thinking.principle.lod.transporter.v2;

import com.csdn.design.patterns.thinking.principle.lod.transporter.Html;
import com.csdn.design.patterns.thinking.principle.lod.transporter.HtmlRequest;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:29
 */
public class HtmlDownloader {

  private NetworkTransporter networkTransporter;

  public Html downloadHtml(String url) {
    HtmlRequest htmlRequest = new HtmlRequest(url);
    byte[] rawHtml = networkTransporter
        .send(htmlRequest.getAddress(), htmlRequest.getContent().getBytes());
    return new Html(rawHtml);
  }
}
