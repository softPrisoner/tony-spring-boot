package com.tony.undertow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * @description UndertowServerApplication
 * @copyright rainbow
 * @date 2020/02/26
 */
@SpringBootApplication
@RestController
public class UndertowServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UndertowServerApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
}
