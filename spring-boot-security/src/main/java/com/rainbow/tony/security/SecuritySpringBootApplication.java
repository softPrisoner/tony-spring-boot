package com.rainbow.tony.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author tony
 * @describe SecuritySpringBootApplication
 * @date 2019-09-02
 */
@SpringBootApplication
@EnableWebSecurity
//@RestController
@EnableOAuth2Sso
//@EnableOAuth2Client
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecuritySpringBootApplication extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySpringBootApplication.class, args);
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .antMatcher("/**")
//                //安全样式匹配
//                .csrf()
//                //token 仓库
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
//                //需要认证请求
//                .authorizeRequests().antMatchers("/", "v1/user/login/**", "/webjars/**", "/error/**").permitAll()
//                //任何请求建群
//                .anyRequest().authenticated().and()
//                //退出登录统一界面
//                .logout().logoutUrl("http://localhost:8080/v1/user/logout").logoutSuccessUrl("http://localhost:8080/v1/user/login").permitAll()
//                .and().formLogin().loginPage("http://localhost:8080/v1/user/login").successForwardUrl("http://localhost:8080/v1/user/index");
//
//    }
//    private Filter ssoFilter() {
//        CompositeFilter filter = new CompositeFilter();
//        List<Filter> filters = new ArrayList<>();
//        filters.add(ssoFilter(facebook(), "/login/facebook"));
//        filters.add(ssoFilter(github(), "/login/github"));
//        filter.setFilters(filters);
//        return filter;
//    }
//
//    private Filter ssoFilter() {
//        CompositeFilter filter = new CompositeFilter();
//        List<Filter> filters = new ArrayList<>();
//
//        OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
//        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
//        facebookFilter.setRestTemplate(facebookTemplate);
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(), facebook().getClientId());
//        tokenServices.setRestTemplate(facebookTemplate);
//        facebookFilter.setTokenServices(tokenServices);
//        filters.add(facebookFilter);
//
//        OAuth2ClientAuthenticationProcessingFilter githubFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/github");
//        OAuth2RestTemplate githubTemplate = new OAuth2RestTemplate(github(), oauth2ClientContext);
//        githubFilter.setRestTemplate(githubTemplate);
//        tokenServices = new UserInfoTokenServices(githubResource().getUserInfoUri(), github().getClientId());
//        tokenServices.setRestTemplate(githubTemplate);
//        githubFilter.setTokenServices(tokenServices);
//        filters.add(githubFilter);
//
//        filter.setFilters(filters);
//        return filter;
//
//    }

    //通过一个github的例子看问题
//    @Bean
//    @ConfigurationProperties("github.client")
//    public AuthorizationCodeResourceDetails github() {
//        return new AuthorizationCodeResourceDetails();
//    }
//
//    @Bean
//    @ConfigurationProperties("github.resource")
//    public ResourceServerProperties githubResource() {
//        return new ResourceServerProperties();
//    }
}
