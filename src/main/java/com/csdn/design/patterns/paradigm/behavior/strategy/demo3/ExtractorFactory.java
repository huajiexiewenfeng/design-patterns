package com.csdn.design.patterns.paradigm.behavior.strategy.demo3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:53
 */
public class ExtractorFactory {

  private static final Map<ResourceFileType, Extractor> extractors = new HashMap<>();

  static {
    extractors.put(ResourceFileType.PDF, new PdfExtractor());
    extractors.put(ResourceFileType.PPT, new PPTExtractor());
    extractors.put(ResourceFileType.WORD, new WordExtractor());
  }

  public static Extractor getExtractor(ResourceFileType type) {
    return extractors.get(type);
  }
}
