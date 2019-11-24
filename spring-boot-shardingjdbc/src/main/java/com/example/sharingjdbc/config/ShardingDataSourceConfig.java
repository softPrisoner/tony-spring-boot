package com.example.sharingjdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tony
 * @describe ShardingDataSourceConfig
 * @date 2019-09-15
 */
@Configuration
@EnableConfigurationProperties(ShardingMasterSlaveConfig.class)
public class ShardingDataSourceConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShardingMasterSlaveConfig.class);
    @Autowired(required = false) //avoid
    private ShardingMasterSlaveConfig shardingMasterSlaveConfig;

    @Bean("dataSource")
    public DataSource masterSlaveDataSource() throws SQLException {
        shardingMasterSlaveConfig.getDataSources().forEach((k, v) -> configDataSource(v));
        Map<String, DataSource> dataSourceMap = new HashMap<>(shardingMasterSlaveConfig.getDataSources());
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap
                , shardingMasterSlaveConfig.getMasterSlaveRule(), new HashMap<>());
        LOGGER.info("master slave data source ");
        return dataSource;
    }

    private void configDataSource(HikariDataSource dataSource) {
        //set max pool size
        dataSource.setMaximumPoolSize(20);
        //set mini idle
        dataSource.setMinimumIdle(5);

    }
}

