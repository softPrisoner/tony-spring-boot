package com.rainbow.tony.shiro.chapter3.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author tony
 * @describe MyRolePermissionResolver
 * @date 2019-09-04
 */
public class MyRolePermissionResolver implements RolePermissionResolver {
    @Override
    @SuppressWarnings("unchecked")
    public Collection<Permission> resolvePermissionsInRole(String roleString) {
//        if ("role1".equals(roleString)) {
        Collection<Permission> permissions = new ArrayList<>();
        permissions.add(new WildcardPermission("menu:*"));
        return permissions;
//        }
    }
}
