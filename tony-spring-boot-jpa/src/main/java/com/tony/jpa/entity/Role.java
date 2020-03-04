package com.tony.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tony.jpa.entity.permission.PermissionGroupEntity;
import com.tony.jpa.entity.permission.RoleGroupEntity;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * @author tony
 * @describe Role
 * @date 2020/02/14
 */
@Data
@ToString(callSuper = true)
@Entity
@Table(name = "role_t")
@Where(clause = "remove=false")
@SQLDelete(sql = "update role set remove=true,last_modified=now() where id=?")
public class Role extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    @Column(name = "remark", columnDefinition = "varchar(200) COMMENT '角色描述'")
    private String remark;
    /**
     * 角色描述
     */
    @Column(name = "role_code", columnDefinition = "varchar(20) COMMENT '角色编码'")
    private String roleCode;
    /**
     * 授权的权限组
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permissions_group_r",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_group_id")
    )
    @JsonIgnore
    private Set<PermissionGroupEntity> permissionGroups;
    /**
     * 关联的角色组
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_role_group_r",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "role_group_id")
    )
    @JsonIgnore
    private Set<RoleGroupEntity> roleGroups;

    /**
     * 所属租户
     */
    @ManyToOne
    @JoinColumn(name = "tenant_id", columnDefinition = "int(11) COMMENT '租户Id'")
    private Tenant tenant;
}
