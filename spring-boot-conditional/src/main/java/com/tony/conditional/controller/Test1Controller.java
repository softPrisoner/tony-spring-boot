package com.tony.conditional.controller;

import com.tony.conditional.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * @describe Test1Controller
 * @date 2019-10-26
 */
@RestController
@RequestMapping("test1")
//当不存在该bean时,装配该类,使用的时候可以定义资源,避免冲突
@ConditionalOnMissingBean(TestService.class)
public class Test1Controller {
    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public String test() {
        return testService.test("test");
    }
}
