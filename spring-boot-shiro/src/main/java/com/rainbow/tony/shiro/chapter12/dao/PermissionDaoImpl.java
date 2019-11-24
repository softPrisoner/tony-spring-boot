package com.rainbow.tony.shiro.chapter12.dao;

import org.apache.shiro.authz.Permission;
import org.springframework.stereotype.Service;

/**
 * @author tony
 * @describe PermissionDaoImpl
 * @date 2019-09-13
 */
@Service
public class PermissionDaoImpl implements PermissionDao {
    @Override
    public Permission createPermission(Permission permission) {
        final String sql = "insert into sys_permissions(permission,description,availble) values(?,?,?)";
        return null;
    }

    @Override
    public void deletePermission(Long permissionId) {

    }
}
