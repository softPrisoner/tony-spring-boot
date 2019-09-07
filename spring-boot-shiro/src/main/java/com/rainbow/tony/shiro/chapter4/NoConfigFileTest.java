package com.rainbow.tony.shiro.chapter4;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author tony
 * @describe NoConfigFileTest
 * @date 2019-09-06
 */
public class NoConfigFileTest {
    //这里可以看出来SecurityManager是最主要的控制器
    @Test
    public void test() {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //设置authenticator
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);
        //设置authorizer
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        authorizer.setPermissionResolver(new WildcardPermissionResolver());
        securityManager.setAuthorizer(authorizer);
        //设置realm
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setEnable(true);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro?useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        //设置过期no salt
        jdbcRealm.setSaltStyle(JdbcRealm.SaltStyle.NO_SALT);
        jdbcRealm.setPermissionsLookupEnabled(true);
        securityManager.setRealm(jdbcRealm);
        securityManager.setRealms(Arrays.asList(jdbcRealm));

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        subject.login(token);
        Assert.assertTrue(subject.isAuthenticated());
    }
}
