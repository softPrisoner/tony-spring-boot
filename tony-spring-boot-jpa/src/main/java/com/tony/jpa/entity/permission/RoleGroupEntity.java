package com.tony.jpa.entity.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tony.jpa.entity.BaseEntity;
import com.tony.jpa.entity.Role;
import com.tony.jpa.entity.Tenant;
import com.tony.jpa.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * @author tony
 * @describe RoleEntity
 * @date 2020/02/14
 */
@EqualsAndHashCode(callSuper = true, exclude = {"users", "roles"})
@Getter
@Setter
@ToString(callSuper = true, exclude = {"users", "roles"})
@Table(name = "role_group_t")
@Entity
@Where(clause = "remove=false")
@SQLDelete(sql = "update role_group_t set remove=true,last_modified=now() where id=?")
public class RoleGroupEntity extends BaseEntity {
    /**
     * 角色组名称
     */
    @Column(name = "name", columnDefinition = "varchar(200) COMMENT '角色组名称'")
    private String name;

    /**
     * 角色描述
     */
    @Column(name = "remark", columnDefinition = "varchar(200) COMMENT '角色描述'")
    private String remark;

    /**
     * 关联的角色
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_role_group_r",
            joinColumns = @JoinColumn(name = "role_group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    /**
     * 关联的用户
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role_group_r",
            joinColumns = @JoinColumn(name = "role_group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private Set<User> users;
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
