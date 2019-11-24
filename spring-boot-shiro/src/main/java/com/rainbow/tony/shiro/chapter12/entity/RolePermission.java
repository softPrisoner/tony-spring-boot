package com.rainbow.tony.shiro.chapter12.entity;

import java.io.Serializable;

/**
 * @author tony
 * @describe RolePermission
 * @date 2019-09-13
 */
public class RolePermission implements Serializable {
    private Long roleId;
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermission that = (RolePermission) o;
        if (permissionId != null ? permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (roleId != null ? roleId.equals(that.roleId) : that.roleId != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
