package com.rainbow.tony.activiti.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tony
 * @describe UserSuccessHandler
 * @date 2019-08-30
 */
public class UserSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String username = (String) authentication.getCredentials(); //账户
        String password = (String) authentication.getPrincipal(); //密码
        String addr = httpServletRequest.getRemoteAddr();
        LOGGER.info("{} auth successfully.username:{} password:{}", addr, username, password);
    }
}
