package com.rainbow.tony.shiro.chapter6;

import org.apache.shiro.authz.Permission;

/**
 * @author tony
 * @describe PermissionService
 * @date 2019-09-07
 */
public interface PermissionService {

    //更新权限
    Permission createPermission(Permission permission);

    //删除权限
    void deletePermission(Long permissionId);
}
