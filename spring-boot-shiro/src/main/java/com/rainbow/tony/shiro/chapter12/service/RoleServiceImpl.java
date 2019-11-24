package com.rainbow.tony.shiro.chapter12.service;

import com.rainbow.tony.shiro.chapter12.dao.RoleDao;
import com.rainbow.tony.shiro.chapter12.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tony
 * @describe RoleServiceImpl
 * @date 2019-09-13
 */
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public void correlationPermission(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    @Override
    public void uncorrelationPermission(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
