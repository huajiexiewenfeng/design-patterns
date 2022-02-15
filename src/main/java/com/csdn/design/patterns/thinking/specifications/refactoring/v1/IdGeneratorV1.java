package com.csdn.design.patterns.thinking.specifications.refactoring.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/15 10:34
 */
public class IdGeneratorV1 {

  private static final Logger logger = LoggerFactory.getLogger(IdGeneratorV1.class);

  public static String generate() {
    String id = "";
    try {
      String token = getLastFieldOfHostName();
      char[] randomChars = generateRandomAlphameric();
      id = String
          .format("%s-%d-%s", token, System.currentTimeMillis(), new String(randomChars));
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return id;
  }

  private static char[] generateRandomAlphameric() {
    char[] randomChars = new char[8];
    int count = 0;
    Random random = new Random();
    while (count < 8) {
      int randomAscii = random.nextInt(122);
      if (randomAscii >= 48 && randomAscii <= 57) {
        randomChars[count] = (char) ('0' + (randomAscii - 48));
        count++;
      } else if (randomAscii >= 65 && randomAscii <= 90) {
        randomChars[count] = (char) ('A' + (randomAscii - 65));
        count++;
      } else if (randomAscii >= 97 && randomAscii <= 122) {
        randomChars[count] = (char) ('a' + (randomAscii - 97));
        count++;
      }
    }
    return randomChars;
  }

  private static String getLastFieldOfHostName() throws UnknownHostException {
    String hostName = InetAddress.getLocalHost().getHostName();
    if (ObjectUtils.isEmpty(hostName)) {
      logger.warn("hostName is null...");
      return null;
    }
    String token = hostName;
    String[] tokens = hostName.split("\\.");
    if (tokens.length > 0) {
      token = tokens[tokens.length - 1];
    }
    return token;
  }

  public static void main(String[] args) {
    System.out.println(generate());
    System.out.println(generate());
  }
}
