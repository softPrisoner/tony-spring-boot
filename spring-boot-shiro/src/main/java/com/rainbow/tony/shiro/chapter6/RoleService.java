package com.rainbow.tony.shiro.chapter6;

/**
 * @author tony
 * @describe RoleService
 * @date 2019-09-07
 */
public interface RoleService {
    Role createRole(Role role);

    void deleteRole(long roleId);

    //添加角色和权限之间的关系
    public void correlationPermissions(Long roleId, Long permissionsIds);

    //移除角色-权限之间关系
    public void uncorrelationPermissions(Long roleId, Long permissionIds);
}
