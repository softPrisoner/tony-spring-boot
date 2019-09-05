package com.rainbow.tony.shiro.service;


import com.rainbow.tony.common.response.PlainResult;

public interface AccountService {
    PlainResult<String> accountLogin(String username, String password);
}
