package com.tony.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author tony
 * @describe BatchJobApplication
 * @date 2019-07-30
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BatchJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchJobApplication.class, args);
    }
}
