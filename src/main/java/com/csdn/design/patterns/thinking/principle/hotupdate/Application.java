package com.csdn.design.patterns.thinking.principle.hotupdate;

/**
 * @Author: xiewenfeng
 * @Date: 2022/2/11 14:13
 */
public class Application {

  public static final RedisConfig redisConfig = new RedisConfig();
  public static final KafkaConfig kafkaConfig = new KafkaConfig();
  public static final MySqlConfig mysqlConfig = new MySqlConfig();

  public static void main(String[] args) {
    ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig, 300L, 300L);
    redisConfigUpdater.run();

    ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig, 300L, 300L);
    kafkaConfigUpdater.run();

    SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 8080);
    simpleHttpServer.addViewer("/config/redis", redisConfig);
    simpleHttpServer.addViewer("/config/kafka", kafkaConfig);
    simpleHttpServer.run();
  }

}
