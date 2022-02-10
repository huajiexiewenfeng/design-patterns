package com.csdn.design.patterns.thinking.oop.interfaces.v2;

import com.csdn.design.patterns.thinking.oop.interfaces.Image;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 16:12
 */
public class PrivateImageStore implements ImageStore{

  public void createBucketIfNotExisting(String bucketName) {
    // ...创建bucket代码逻辑...
    // ...失败会抛出异常..
  }

  @Override
  public String upload(Image image, String bucketName) {
    createBucketIfNotExisting(bucketName);
    //...上传图片到私有云...
    // ...返回图片的url...
    return null;
  }

  @Override
  public Image download(String url) {
    //...从私有云下载图片...
    return null;
  }
}
