package com.tony.mongo.aggr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author tony
 * @describe MongoApplication
 * @date 2019/12/20
 */
@SpringBootApplication
public class MongoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MongoApplication.class);
        app.addListeners(new ApplicationPidFileWriter("application.pid"));
        app.run(args);
    }
}
