package com.rainbow.tony.security.config;

import com.rainbow.tony.security.realm.UserRealm;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tony
 * @describe shiroBaseConfig
 * @date 2019-09-02
 */
@Configuration
public class ShiroBaseConfig {
    public UserRealm getUserRealm() {
        return new UserRealm();
    }

    public RealmSecurityManager getSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getUserRealm());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        //init  filter bean
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(getSecurityManager());
        //login page url
        bean.setLoginUrl("/v1/user/loginPre");
        //success
        bean.setSuccessUrl("/v1/user/index");
        //set unauthorized path
        bean.setUnauthorizedUrl("/404");
        //通过map映射配置路径拦截映射
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/login", "anon");
        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }


}
