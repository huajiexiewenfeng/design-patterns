package com.csdn.design.patterns.thinking.principle.lod.transporter.v2;

import com.csdn.design.patterns.thinking.principle.lod.transporter.Html;
import com.csdn.design.patterns.thinking.principle.lod.transporter.v1.HtmlDownloader;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:44
 */
public class Document {

  private Html html;
  private String url;

  public Document(Html html, String url) {
    this.html = html;
    this.url = url;
  }
}
