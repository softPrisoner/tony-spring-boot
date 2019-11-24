package com.example.sharingjdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tony
 * @describe ShardingMasterSlaveConfig
 * @date 2019-09-15
 */
@Data
//property prefix
@ConfigurationProperties(prefix = "sharding.jdbc")
public class ShardingMasterSlaveConfig {
    private Map<String, HikariDataSource> dataSources = new HashMap<>();
    private MasterSlaveRuleConfiguration masterSlaveRule;

}
