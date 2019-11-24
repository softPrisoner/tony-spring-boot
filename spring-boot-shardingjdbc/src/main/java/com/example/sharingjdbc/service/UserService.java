package com.example.sharingjdbc.service;

import com.example.sharingjdbc.entity.UserEntity;

import java.util.List;

/**
 * @author tony
 * @describe UserService
 * @date 2019-09-15
 */
public interface UserService {
    /**
     * 保存userduixiang
     */
    void saveUser(UserEntity entity);
/**
 * 获取所有userduixiang
 * */
    List<UserEntity> getUsers();
}
