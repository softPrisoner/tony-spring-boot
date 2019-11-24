package com.rainbow.tony.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * @author tony
 * @describe FooService
 * @date 2019-09-02
 */
@Service
public class FooService {
    @Secured("admin")
    public String test() {
        return "test";
    }
}
