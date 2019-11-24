package com.rainbow.tony.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;

/**
 * @author tony
 * @describe SecurityConfig
 * @date 2019-09-03
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/hello");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //初始化filter
        http.addFilterBefore(
                new UsernamePasswordAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("/hello")
                .hasRole("tony")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/v1/user/loginPre")
                .loginProcessingUrl("/v1/user/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((httpServletRequest, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("success");
                    out.flush();
                })
                .failureHandler((request, response, e) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write("failed");
                    out.flush();
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
        ;
    }
}
