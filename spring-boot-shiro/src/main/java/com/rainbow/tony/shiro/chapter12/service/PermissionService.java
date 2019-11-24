package com.rainbow.tony.shiro.chapter12.service;

import org.apache.shiro.authz.Permission;

/**
 * @author tony
 * @describe PermissionService
 * @date 2019-09-13
 */
public interface PermissionService {
    //创建权限
    public Permission createPermission(Permission permission);

    //删除权限
    public void deletePermission(Long permissionId);
}
