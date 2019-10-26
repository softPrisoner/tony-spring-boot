package com.tony.conditional;

import com.tony.conditional.service.TestService;
import com.tony.conditional.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author tony
 * @describe ConditionalApplication
 * @date 2019-10-26
 */
@SpringBootApplication
public class ConditionalApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConditionalApplication.class, args);
    }

    //第一种用法,对象不存在才需要装配
    @Bean
    @ConditionalOnMissingBean(TestService.class)
    public TestService testConditionalOnMissingBean() {
        LOGGER.info("###################condition#######################");
        return new TestServiceImpl();
    }
}
