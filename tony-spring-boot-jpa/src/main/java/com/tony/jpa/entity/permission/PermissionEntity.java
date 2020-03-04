package com.tony.jpa.entity.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tony.jpa.entity.BaseEntity;
import com.tony.jpa.enums.SwitchEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * Permission Entity
 *
 * @author tony
 * @describe the entity of permission
 * @date 2020/02/14
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"parentPermission", "childPermissions", "permissionGroups"})
@Entity
@Table(name = "permission_t")
@Where(clause = "remove=false")
@SQLDelete(sql = "update permission_t set remove=true,last_modified=now() where id =?")
public class PermissionEntity extends BaseEntity {
    /**
     * 权限中文名
     */
    @Column(name = "cn_name", columnDefinition = "varchar(200) COMMENT '中文名称'")
    private String cnName;
    /**
     * 权限英文名
     */
    @Column(name = "en_name", columnDefinition = "varchar(200) COMMENT '英文名称'")
    private String enName;

    /**
     * 关联的子查询
     */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "parentPermission")
    private Set<PermissionEntity> childPermissions;
    /**
     * 关联的父权限
     */
    @JsonIgnore
    @JoinColumn(name = "parent_id", columnDefinition = "int(11) COMMENT '父权限ID'")
    @ManyToOne(fetch = FetchType.LAZY)
    private PermissionEntity parentPermission;

    /**
     * 标识符
     */
    @Column(name = "code", columnDefinition = "varchar(200) COMMENT '标识符'")
    private String code;
    /**
     * 说明
     */
    @Column(name = "remark", columnDefinition = "varchar(200) COMMENT '说明'")
    private String remark;
    /**
     * 关联的权限
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_permission_group_permission",
            joinColumns = {@JoinColumn(name = "permission_id", columnDefinition = "int(11) COMMENT '权限ID'")})
    @JsonIgnore
    private Set<PermissionGroupEntity> permissionGroups;
    /**
     * 资源地址
     */
    @Column(name = "uri", columnDefinition = "varchar(200) COMMENT '资源地址'")
    private String uri;
    /**
     * 样式
     */
    @Column(name = "style", columnDefinition = "varchar(200) COMMENT '样式'")
    private String style;
    /**
     * 图标
     */
    @Column(name = "icon", columnDefinition = "varchar(50) COMMENT '图标'")
    private String icon;
    /**
     * 资源码
     */
    @Column(name = "resource_code", columnDefinition = "varchar(100) COMMENT '资源码'")
    private String resourceCode;

    /**
     * 是否生效
     */
    @Column(name = "is_effect", columnDefinition = "varchar(20) COMMENT '是否生效'")
    private SwitchEnum isEffect;

    /**
     * 前端路由的名称
     */
    @Column(name = "route_name", columnDefinition = "varchar(100) COMMENT '前端路由的名称'")
    private String routeName;
    /**
     * 前端路由地址
     */
    @Column(name = "route_path", columnDefinition = "varchar(100) COMMENT '前端路由地址'")
    private String routePath;
    /**
     * 前端视图组件
     */
    @Column(name = "component_name", columnDefinition = "varchar(200) COMMENT '前端对应的视图组件'")
    private String componentName;
    /**
     * 是否是叶子节点
     */
    @Column(name = "isLeaf", columnDefinition = "bit(1) default 1 COMMENT '是否是叶子节点'")
    private Boolean isLeaf = false;
    /**
     * 排序
     */
    @Column(name = "sort", columnDefinition = "int(8) COMMENT '排序'")
    private Integer sort;
}
