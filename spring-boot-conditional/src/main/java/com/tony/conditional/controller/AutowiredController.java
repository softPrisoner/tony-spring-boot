package com.tony.conditional.controller;

import com.tony.conditional.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * @describe AutowiredController
 * @date 2019-10-26
 */
@RestController
@RequestMapping("/test3")
@ConditionalOnBean(TestService.class)//启动正常,调用异常,不存在类型对象
public class AutowiredController {
    @Autowired
    TestService testService;


    @GetMapping("test3")
    public String test3() {
        return testService.test("autowire test");
    }
}
