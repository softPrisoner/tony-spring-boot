package com.tony.batch.test.dto.config;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tony
 * @describe DozerConfig
 * @date 2019-08-01
 */
@Configuration
public class DozerConfig {
    public Mapper dozerMapper() {
        //指定dozer mapping的配置文件(放到resources类路径下即可),可以添加多个xml文件,用逗号隔开\
        return DozerBeanMapperBuilder.create()
                .withMappingFiles("dozerBeanMapping.xml")
                .withMappingBuilder(beanMappingBuilder())
                .build();
    }

    //关闭隐式匹配,指定匹配字段
    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                System.out.println(System.currentTimeMillis());
                //个性化配置添加在这里
                System.out.println(System.currentTimeMillis());
            }
        };
    }
}
