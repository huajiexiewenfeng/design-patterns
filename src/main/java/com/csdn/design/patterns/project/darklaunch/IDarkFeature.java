package com.csdn.design.patterns.project.darklaunch;

/**
 * @Author: xiewenfeng
 * @Date: 2022/3/4 15:45
 */
public interface IDarkFeature {

  boolean enabled();

  boolean dark(long darkTarget);

  boolean dark(String darkTarget);

}
