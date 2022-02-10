package com.csdn.design.patterns.theory.interfaces.v2;

import com.csdn.design.patterns.theory.interfaces.Image;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 16:10
 */
public class AliyunImageStore implements ImageStore{

  public void createBucketIfNotExisting(String bucketName) {
    // ...创建bucket代码逻辑...
    // ...失败会抛出异常..
  }

  public String generateAccessToken() {
    // ...根据accesskey/secrectkey等生成access token
    return "";
  }

  @Override
  public String upload(Image image, String bucketName) {
    // 创建 bucket
    this.createBucketIfNotExisting(bucketName);
    // 生成 accessToken
    String accessToken = this.generateAccessToken();
    // ...上传图片到阿里云...
    // ...返回图片存储在阿里云上的地址(url）...
    return null;
  }

  @Override
  public Image download(String url) {
    //...从阿里云下载图片...
    return null;
  }
}
