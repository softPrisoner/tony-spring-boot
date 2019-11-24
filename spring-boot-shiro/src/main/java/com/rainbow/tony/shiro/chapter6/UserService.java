package com.rainbow.tony.shiro.chapter6;

import java.util.Set;

/**
 * @author tony
 * @describe UserService
 * @date 2019-09-07
 */
public interface UserService {
    public User createUser(User user); //创建账户

    public void changePassword(Long userId, String newPassword);//修改密码

    public void correlationRoles(Long userId, Long... roleIds); //添加用户-角色关系

    public void uncorrelationRoles(Long userId, Long... roleIds);// 移除用户-角色关系

    public User findByUsername(String username);// 根据用户名查找用户

    public Set<String> findRoles(String username);// 根据用户名查找其角色

    public Set<String> findPermissions(String username); //根据用户名查找其权限
}
