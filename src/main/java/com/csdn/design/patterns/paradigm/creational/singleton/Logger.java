package com.csdn.design.patterns.paradigm.creational.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/16 11:03
 */
public class Logger {

  private FileWriter writer;
  private static final Logger instance = new Logger();

  public Logger() {
    File file = new File("...");
    try {
      writer = new FileWriter(file, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Logger getInstance() {
    return instance;
  }

  public void log(String message) {
    try {
      writer.write(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
