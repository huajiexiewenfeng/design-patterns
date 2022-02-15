package com.csdn.design.patterns.thinking.specifications.refactoring.v3;

import com.csdn.design.patterns.thinking.specifications.refactoring.v2.IdGenerator;
import com.csdn.design.patterns.thinking.specifications.refactoring.v2.LogTraceIdGenerator;
import com.google.common.annotations.VisibleForTesting;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * 编写可测试性代码
 *
 * @Author: xiewenfeng
 * @Date: 2022/2/15 11:14
 */
public class RandomIdGenerator implements LogTraceIdGenerator {

  private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

  @Override
  public String generate() {
    String substrOfHostName = getLastFieldOfHostName();
    long currentTimeMillis = System.currentTimeMillis();
    String randomString = generateRandomAlphameric(8);
    String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
    return id;
  }

  private String getLastFieldOfHostName() {
    String substrOfHostName = null;
    try {
      String hostName = InetAddress.getLocalHost().getHostName();
      if (ObjectUtils.isEmpty(hostName)) {
        logger.warn("hostName is null...");
        return null;
      }
      substrOfHostName = getLastSubstrSplittedByDot(hostName);
    } catch (UnknownHostException e) {
      logger.warn("Failed to get the host name.", e);
    }
    return substrOfHostName;
  }

  @VisibleForTesting
  public String getLastSubstrSplittedByDot(String hostName) {
    if (ObjectUtils.isEmpty(hostName)) {
      return null;
    }
    String[] tokens = hostName.split("\\.");
    String substrOfHostName = tokens[tokens.length - 1];
    return substrOfHostName;
  }

  @VisibleForTesting
  public String generateRandomAlphameric(int length) {
    if (length < 0) {
      return null;
    }
    char[] randomChars = new char[length];
    int count = 0;
    Random random = new Random();
    while (count < length) {
      int maxAscii = 'z';
      int randomAscii = random.nextInt(maxAscii);
      boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
      boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
      boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
      if (isDigit || isUppercase || isLowercase) {
        randomChars[count] = (char) (randomAscii);
        ++count;
      }
    }
    return new String(randomChars);
  }

  public static void main(String[] args) {
    IdGenerator idGenerator = new RandomIdGenerator();
    System.out.println(idGenerator.generate());
    System.out.println(idGenerator.generate());
  }
}
