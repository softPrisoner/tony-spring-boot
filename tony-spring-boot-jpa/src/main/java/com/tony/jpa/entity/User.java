package com.tony.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User Info
 *
 * @author tony
 * @describe User
 * @date 2020/02/14
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Where(clause = "remove=false")
@Table(name = "tb_user")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = {"createTime", "isRemoved"})
@SQLDelete(sql = "update tb_user set remove=true,last_modified =now() where id = ?")
public class User extends BaseEntity {
    /**
     * 用户姓名
     */
    @Column(name = "real_name", columnDefinition = "varchar(200) COMMENT '用户姓名'")
    private String realName;
    /**
     * 用户名
     */
    @Column(name = "user_name", columnDefinition = "varchar(200) COMMENT '用户名'")
    private String userName;
    /**
     * 用户密码
     */
    @Column(name = "password", columnDefinition = "varchar(200) COMMENT '用户密码'")
    private String password;

    /**
     * 用户账户是否冻结
     */
    @Column(name = "account_non_locked", columnDefinition = "bit COMMENT '用户是否冻结'")
    private Boolean accountNonLocked;

    /**
     * 用户是否可用
     */
    @Column(name = "is_enabled", columnDefinition = "bit COMMENT '用户是否可用'")
    private Boolean isEnabled;
}
