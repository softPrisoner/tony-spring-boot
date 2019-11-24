package com.rainbow.tony.security.controller;

import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author tony
 * @describe FooController
 * @date 2019-09-02
 */
@Controller
@RequestMapping("/v1/usr")
public class FooController {
    @GetMapping("/foo")
    @ResponseBody
    public void foo(Principal principal) {
        Authentication authentication = (Authentication) principal;
        User user = (User) authentication.getPrincipal();
        final String username = user.getUsername();
        final String password = user.getPassword();
        System.out.println(username + " " + password);
    }

    @GetMapping("/login")
    public String login() {
        return "index.html";
    }

    @GetMapping("/ins")
    public void viewInnerSecurityFile() {
        System.out.println("this is admin service test");
    }

    @ExceptionHandler(StorageResolverException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageResolverException exc) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        SecurityContext context = SecurityContextHolder.getContext();
        //NPE
        Authentication authentication = context.getAuthentication();
        System.out.println(authentication);
        assert authentication.isAuthenticated();
        return "success";
    }
}
