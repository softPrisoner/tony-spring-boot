package com.rainbow.tony.shiro.chapter12.service;

import com.rainbow.tony.shiro.chapter12.entity.Role;

/**
 * @author tony
 * @describe RoleService
 * @date 2019-09-13
 */
public interface RoleService {
    public Role createRole(Role role);

    public void deleteRole(Long roleId);

    public void correlationPermission(Long roleId, Long... permissionId);

    public void uncorrelationPermission(Long roleId, Long... permissionIds);
}
