package com.csdn.design.patterns.thinking.principle.lod.transporter.v2;

import com.csdn.design.patterns.thinking.principle.lod.transporter.Html;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 16:50
 */
public class DocumentFactory {

  private HtmlDownloader downloader;

  public DocumentFactory(HtmlDownloader downloader) {
    this.downloader = downloader;
  }

  public Document createDocument(String url) {
    Html html = downloader.downloadHtml(url);
    return new Document(html, url);
  }
}
