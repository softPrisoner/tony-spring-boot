package com.rainbow.tony.shiro.chapter12.dao;

import com.rainbow.tony.shiro.chapter12.entity.Role;

/**
 * @author tony
 * @describe RoleDao
 * @date 2019-09-13
 */
public interface RoleDao {
    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
