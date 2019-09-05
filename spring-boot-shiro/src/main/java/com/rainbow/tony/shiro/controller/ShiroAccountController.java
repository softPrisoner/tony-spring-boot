package com.rainbow.tony.shiro.controller;


import com.rainbow.tony.common.response.PlainResult;
import com.rainbow.tony.shiro.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author tony
 * @describe ShiroAccountController
 * @date 2019-08-22
 */
@Controller("/shiro/v1")
public class ShiroAccountController {
    @Resource
    private AccountService userService;

    @PostMapping("/login")
    public PlainResult<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.accountLogin(username, password);
    }
}
