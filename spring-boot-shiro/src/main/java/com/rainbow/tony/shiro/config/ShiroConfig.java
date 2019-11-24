package com.rainbow.tony.shiro.config;

/**
 * @author tony
 * @describe ShiroConfig
 * @date 2019-09-10
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ShiroConfig {
    @PostConstruct
    public void init() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-login.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
    }

    public Subject getSubject() {
        return SecurityUtils.getSubject();
    }
}
