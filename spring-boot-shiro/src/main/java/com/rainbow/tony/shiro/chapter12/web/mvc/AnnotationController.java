package com.rainbow.tony.shiro.chapter12.web.mvc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tony
 * @describe AnnotationController
 * @date 2019-09-13
 */
public class AnnotationController {
    @RequestMapping("/hello1")
    public String hello1() {
        SecurityUtils.getSubject().checkRoles("admin");
        return "success";
    }

    @RequiresRoles("admin")
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }
}
