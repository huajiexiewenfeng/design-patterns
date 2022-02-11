package com.csdn.design.patterns.thinking.principle.lod.transporter.v1;

import com.csdn.design.patterns.thinking.principle.lod.transporter.Html;
import com.csdn.design.patterns.thinking.principle.lod.transporter.v1.HtmlDownloader;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:44
 */
public class Document {

  private Html html;
  private String url;

  public Document(String url) {
    this.url = url;
    HtmlDownloader downloader = new HtmlDownloader();
    this.html = downloader.downloadHtml(url);
  }
}
