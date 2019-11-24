package com.rainbow.tony.security.arch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author tony
 * @describe ApplicationSecurity
 * @date 2019-09-02
 */
@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 10) //设置优先级别
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    //authenticationManagerBuilder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("").roles("", "").password("")
                .and().withUser("").roles("").password("");
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        //from spring 5 forces without cleartext which must be encrety
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/foo/**")
//                .authorizeRequests()
//                .antMatchers("/foo/bar").hasRole("BAR")
//                .antMatchers("/foo/spam").hasRole("SPAM")
//                .anyRequest().authenticated();
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/v1/user/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/v1/user/loginPre");
    }
//    将Web安全性和方法安全性结合起来并不罕见。过滤器链提供用户体验功能，如身份验证和重定向到登录页面等，
//   @Autowired
//    public void initialize(AuthenticationManagerBuilder builder, DataSource dataSource) throws Exception {
//        builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
//                .password("secret").roles("USER");
//    }
}
