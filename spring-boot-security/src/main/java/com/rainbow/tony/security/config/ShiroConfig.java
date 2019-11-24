package com.rainbow.tony.security.config;

import com.rainbow.tony.security.realm.UserRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tony
 * @describe ShiroConfig
 * @date 2019-09-02
 */
@Configuration
public class ShiroConfig {
    @Bean
    public UserRealm getUserRealm() {
        return new UserRealm();
    }

    @Bean
    DefaultSecurityManager getSecurityManager() {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(getUserRealm());
        return manager;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/doLogin", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }
}
