package com.rainbow.tony.shiro.chapter12.dao;

import org.apache.shiro.authz.Permission;

/**
 * @author tony
 * @describe PermissionDao
 * @date 2019-09-13
 */
public interface PermissionDao {
    public Permission createPermission(final Permission permission);

    //删除鉴权信息
    public void deletePermission(Long permissionId);

}
