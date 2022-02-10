package com.csdn.design.patterns.thinking.oop.interfaces.v1;

import com.csdn.design.patterns.thinking.oop.interfaces.Image;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 15:57
 */
public class ImageProcessingJob {

  private static final String BUCKET_NAME = "ai_images_bucket";

  public void process() {
    // 获取图片，封装成 image 对象
    Image image = new Image();
    AliyunImageStore imageStore = new AliyunImageStore();
    // 创建 bucket
    imageStore.createBucketIfNotExisting(BUCKET_NAME);
    // 生成 accessToken
    String accessToken = imageStore.generateAccessToken();
    // 上传图片
    imageStore.uploadToAliyun(image, BUCKET_NAME, accessToken);
  }

}
