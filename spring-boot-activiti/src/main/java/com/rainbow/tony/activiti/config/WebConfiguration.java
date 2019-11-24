package com.rainbow.tony.activiti.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author tony
 * @describe WebConfiguration
 * @date 2019-08-30
 */
@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/", "/v1/usr/**").permitAll()
                .antMatchers("/", "v1/task/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/v1/usr/loginPre/")
                .permitAll()
                .successHandler(new UserSuccessHandler())
                .and().logout()
                .logoutSuccessUrl("/home")
                .permitAll()
                .invalidateHttpSession(true)
                .and().rememberMe().tokenValiditySeconds(1209600);

    }
}
