package com.rainbow.tony.security.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author tony
 * @describe LoginController
 * @date 2019-09-02
 */
@Controller
@RequestMapping("/v1/user")
public class LoginController {
    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/loginPre")
    public String loginPre() {
        return "shiro-login.html";
    }

    @PostMapping("/login")
    public void login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            LOGGER.info("login success");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            LOGGER.info("login failed");
        }
    }
}
