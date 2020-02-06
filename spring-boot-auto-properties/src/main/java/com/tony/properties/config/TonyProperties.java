package com.tony.properties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * PropertiesConfig support application.properties manually.
 *
 * @author tony
 * @describe TonyProperties
 * @date 2020/02/06
 */
@Data
@ConfigurationProperties(prefix = "com.tony")
public class TonyProperties {
    private Integer port;
    private String address;

}
