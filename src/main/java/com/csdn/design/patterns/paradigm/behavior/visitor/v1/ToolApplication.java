package com.csdn.design.patterns.paradigm.behavior.visitor.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/18 15:38
 */
public class ToolApplication {

  public static void main(String[] args) {
    Extractor extractor = new Extractor();
    List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
    for (ResourceFile resourceFile : resourceFiles) {
      resourceFile.accept(extractor);
    }

    Compressor compressor = new Compressor();
    for (ResourceFile resourceFile : resourceFiles) {
      resourceFile.accept(compressor);
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
