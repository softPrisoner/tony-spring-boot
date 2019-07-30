package com.tony.batch.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author tony
 * @describe BatchConfig
 * @date 2019-07-30
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {
    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
