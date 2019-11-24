package com.rainbow.tony.shiro.service.impl;

import com.rainbow.tony.common.response.PlainResult;
import com.rainbow.tony.shiro.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public PlainResult<String> accountLogin(String username, String password) {

        return null;
    }
}
