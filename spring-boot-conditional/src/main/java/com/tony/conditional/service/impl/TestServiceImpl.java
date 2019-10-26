package com.tony.conditional.service.impl;

import com.tony.conditional.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author tony
 * @describe TestServiceImpl
 * @date 2019-10-26
 */
//@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test(String param) {
        return "test conditional bean";
    }
}
