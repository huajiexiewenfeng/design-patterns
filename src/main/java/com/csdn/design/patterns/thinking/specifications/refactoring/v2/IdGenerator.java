package com.csdn.design.patterns.thinking.specifications.refactoring.v2;

import com.csdn.design.patterns.thinking.specifications.refactoring.exception.IdGenerationFailureException;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 11:13
 */
public interface IdGenerator {

  String generate() throws IdGenerationFailureException;
}
