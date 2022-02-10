package com.csdn.design.patterns.theory.interfaces.v2;

import com.csdn.design.patterns.theory.interfaces.Image;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 16:13
 */
public class ImageProcessingJob {

  private static final String BUCKET_NAME = "ai_images_bucket";

  public void process() {
    // 获取图片，封装成 image 对象
    Image image = new Image();
    ImageStore imageStore = new AliyunImageStore();
    // 上传图片
    imageStore.upload(image, BUCKET_NAME);
  }

}
