package com.csdn.design.patterns.thinking.principle.lod.transporter.v1;

import com.csdn.design.patterns.thinking.principle.lod.transporter.Html;
import com.csdn.design.patterns.thinking.principle.lod.transporter.HtmlRequest;
import com.csdn.design.patterns.thinking.principle.lod.transporter.v1.NetworkTransporter;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:29
 */
public class HtmlDownloader {

  private NetworkTransporter networkTransporter;

  public Html downloadHtml(String url) {
    byte[] rawHtml = networkTransporter.send(new HtmlRequest(url));
    return new Html(rawHtml);
  }
}
