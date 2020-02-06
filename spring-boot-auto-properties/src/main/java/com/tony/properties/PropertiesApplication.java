package com.tony.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 *Properties starter for auto property test.
 * @author tony
 * @describe PropertiesApplication
 * @date 2020/02/06
 */
@SpringBootApplication
public class PropertiesApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PropertiesApplication.class);
        application.addListeners(new ApplicationPidFileWriter("application.pid"));
        application.run(args);
    }
}
