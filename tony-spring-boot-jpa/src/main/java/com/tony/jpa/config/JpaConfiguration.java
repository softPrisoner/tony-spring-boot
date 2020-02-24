package com.tony.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tony
 * @description JpaConfiguration
 * @copyright rainbow
 * @date 2020/02/24
 */
@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = {"com.tony.jpa.entity"})
@EnableJpaRepositories(basePackages = {"com.tony.jpa.repository"})
public class JpaConfiguration {


}
