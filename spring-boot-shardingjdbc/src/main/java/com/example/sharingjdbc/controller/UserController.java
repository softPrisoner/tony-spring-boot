package com.example.sharingjdbc.controller;

import com.example.sharingjdbc.entity.UserEntity;
import com.example.sharingjdbc.service.UserService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tony
 * @describe UserController
 * @date 2019-09-15
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/save")
    public String saveUser() {
        UserEntity user = new UserEntity(1, "zhang3", 22);
        userService.saveUser(user);
        return "success";
    }

    @PostMapping("/get")
    public String getUser() {
        List<UserEntity> users = userService.getUsers();
        return new Gson().toJson(users);
    }
}
