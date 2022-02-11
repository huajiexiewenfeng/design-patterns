package com.csdn.design.patterns.thinking.principle.hotupdate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:22
 */
public class SimpleHttpServer implements Runnable {

  private String host;
  private int port;
  private Map<String, List<Viewer>> viewers = new HashMap<>();

  public SimpleHttpServer(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void addViewer(String urlDirectory, Viewer viewer) {
    if (!viewers.containsKey(urlDirectory)) {
      viewers.put(urlDirectory, Collections.singletonList(viewer));
    }
    this.viewers.get(urlDirectory).add(viewer);
  }

  @Override
  public void run() {

  }
}
