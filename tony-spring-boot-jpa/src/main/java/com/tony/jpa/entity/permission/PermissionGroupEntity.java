package com.tony.jpa.entity.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tony.jpa.entity.BaseEntity;
import com.tony.jpa.entity.Role;
import com.tony.jpa.entity.Tenant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * Permission Group Entity
 *
 * @author tony
 * @describe PermissionGroup
 * @date 2020/02/14
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"roles", "permissions"})
@ToString(callSuper = true, exclude = {"roles", "permissions"})
@Entity
@Table(name = "permission_group_t")
@Where(clause = "remove=false")
@SQLDelete(sql = "update permission_group_t set remove=true,last_modified=now() where id=?")
public class PermissionGroupEntity extends BaseEntity {
    /**
     * 名称
     */
    @Column(name = "name", columnDefinition = "varchar(200) COMMENT '名称'")
    private String name;
    /**
     * 备注
     */
    @Column(name = "remark", columnDefinition = "varchar(200) COMMENT '备注'")
    private String remark;
    /**
     * 关联的权限
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permission_group_permission_r",
            joinColumns = {@JoinColumn(name = "permission_group_id", columnDefinition = "int(11) COMMENT '权限组ID'")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", columnDefinition = "int(11) COMMENT '权限ID'")}
    )
    /**
     * 权限集合
     */
    @JsonIgnore
    private Set<PermissionEntity> permissions;
    /**
     * 关联的角色数量
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permissions_group_r", joinColumns = {@JoinColumn(name = "permission_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    /**
     * 权限组下的角色集合
     */
    @JsonIgnore
    private Set<Role> roles;

    /**
     * 编号
     */
    @Column(name = "code", columnDefinition = "varchar(32) COMMENT '编号'")
    private String code;

    /**
     * 所属租户
     */
    @ManyToOne
    @JoinColumn(name = "tenant_id", columnDefinition = "int(11) COMMENT '租户Id'")
    private Tenant tenant;
}
