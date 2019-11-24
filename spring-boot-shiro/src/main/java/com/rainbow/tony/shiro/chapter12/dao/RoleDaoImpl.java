package com.rainbow.tony.shiro.chapter12.dao;

import com.rainbow.tony.shiro.chapter12.entity.Role;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.Objects;

/**
 * @author tony
 * @describe RoleDaoImpl
 * @date 2019-09-13
 */
@Service
public class RoleDaoImpl extends JdbcDaoSupport implements RoleDao {
    @Override
    public Role createRole(Role role) {
        final String sql = "insert into sys_roles(role,description,available) values(?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(connection -> {
            PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
            //获取角色
            psst.setString(1, role.getRole());
            //获取描述
            psst.setString(2, role.getDecription());
            //判断是否可用
            psst.setBoolean(3, role.getAvailable());
            return psst;
        }, keyHolder);
        role.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return role;
    }

    @Override
    public void deleteRole(Long roleId) {
        //首先把和role相关联的表数据删除掉
        String sql = "delete from sys_users_roles where role_id=?";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "insert into sys_roles_permissions(role_id,permission_id) values(?,?)";
        for (Long permissionId : permissionIds) {
            if (exists(roleId, permissionId)) {
                getJdbcTemplate().update(sql, roleId, permissionId);
            }
        }
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if (permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "delete from sys_roles_permissions where role_id=? and permission_id=?";
        for (Long permissionId : permissionIds) {
            if (exists(roleId, permissionId)) {
                getJdbcTemplate().update(sql, roleId, permissionId);
            }
        }
    }

    private boolean exists(Long roleId, Long permissionId) {
        String sql = "select count(1) from sys_roles_permissions where role_id=? and permission_id=?";
        return getJdbcTemplate().queryForObject(sql, Integer.class, roleId, permissionId) != 0;
    }
}
