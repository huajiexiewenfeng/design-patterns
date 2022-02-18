package com.csdn.design.patterns.paradigm.behavior.strategy.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:56
 */
public class ToolApplication {

  public static void main(String[] args) {
    List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
    for (ResourceFile resourceFile : resourceFiles) {
      Extractor extractor = ExtractorFactory.getExtractor(resourceFile.getType());
      extractor.extract2txt(resourceFile);
    }
  }

  private static List<ResourceFile> listAllResourceFiles(String arg) {
    List<ResourceFile> resourceFiles = new ArrayList<>();
    resourceFiles.add(new PdfFile("A.pdf"));
    resourceFiles.add(new PPTFile("A.ppt"));
    resourceFiles.add(new WordFile("A.doc"));
    return resourceFiles;
  }
}
