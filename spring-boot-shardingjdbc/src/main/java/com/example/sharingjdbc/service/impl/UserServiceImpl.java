package com.example.sharingjdbc.service.impl;

import com.example.sharingjdbc.entity.UserEntity;
import com.example.sharingjdbc.repository.UserRepository;
import com.example.sharingjdbc.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tony
 * @describe UserServiceImpl
 * @date 2019-09-15
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public void saveUser(UserEntity entity) {
        userRepository.save(entity);
    }

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> entities = userRepository.findAll();
        return entities;
    }
}
