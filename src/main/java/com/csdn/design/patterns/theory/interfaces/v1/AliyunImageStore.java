package com.csdn.design.patterns.theory.interfaces.v1;

import com.csdn.design.patterns.theory.interfaces.Image;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 15:54
 */
public class AliyunImageStore {

  public void createBucketIfNotExisting(String bucketName) {
    // ...创建bucket代码逻辑...
    // ...失败会抛出异常..
  }

  public String generateAccessToken() {
    // ...根据accesskey/secrectkey等生成access token
    return "";
  }

  public String uploadToAliyun(Image image, String bucketName, String accessToken) {
    // ...上传图片到阿里云...
    // ...返回图片存储在阿里云上的地址(url）...
    return "";
  }

  public Image downloadFromAliyun(String url, String accessToken) {
    //...从阿里云下载图片...
    return null;
  }
}
