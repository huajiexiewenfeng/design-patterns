package com.csdn.design.patterns.theory.interfaces.v2;

import com.csdn.design.patterns.theory.interfaces.Image;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/9 16:09
 */
public interface ImageStore {

  String upload(Image image, String bucketName);

  Image download(String url);
}
