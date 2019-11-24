package com.example.sharingjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tony
 * @describe ShardingJdbcApplication
 * @date 2019-09-15
 */
@SpringBootApplication
public class ShardingJdbcApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShardingJdbcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
        LOGGER.info("sharding jdbc start");
    }
}
