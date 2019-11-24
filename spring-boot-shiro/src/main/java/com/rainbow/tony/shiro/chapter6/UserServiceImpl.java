package com.rainbow.tony.shiro.chapter6;

import java.util.Set;

/**
 * @author tony
 * @describe UserServiceImpl
 * @date 2019-09-07
 */
public class UserServiceImpl implements UserService {
    private static final PasswordHelper passwordHelper = new PasswordHelper();

    @Override
    public User createUser(User user) {
        passwordHelper.encryptPassword(user);
        return null;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
