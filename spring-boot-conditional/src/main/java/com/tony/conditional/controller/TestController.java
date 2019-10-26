package com.tony.conditional.controller;

import com.tony.conditional.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.TestCSService;

/**
 * @author tony
 * @describe controller
 * @date 2019-10-26
 */

@RestController
@RequestMapping("/test")

//@ConditionalOnBean(value = TestService.class)
//如果条件不符合,则不装配当前bean,则调用不到服务,真正业务场景不是很适用
@ConditionalOnClass(TestCSService.class)
public class TestController {
    //@Autowired(required = false)
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test("test");
    }
}
