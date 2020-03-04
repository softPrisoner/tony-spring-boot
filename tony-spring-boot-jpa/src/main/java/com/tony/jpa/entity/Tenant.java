package com.tony.jpa.entity;

import javax.persistence.Column;

/**
 * @author tony
 * @describe Tenant
 * @date 2020/02/14
 */
public class Tenant extends BaseEntity {
    /**
     * 用户是否冻结没有冻结
     */
    @Column(name = "account_non_locked", columnDefinition = "bit COMMENT '用户是否冻结'")
    private Boolean accountNonLocked;

    /**
     * 用户是否可用
     */
    @Column(name = "enabled", columnDefinition = "bit COMMENT '用户是否可用'")
    private Boolean enabled;

    /**
     * 停用原因
     */
    @Column(name = "disable_reason", columnDefinition = "varchar(64) COMMENT '停用原因'")
    private String disableReason;

    /**
     * tenant 安全秘钥 token
     */
    @Column(name = "token", columnDefinition = "text COMMENT '用户是否可用'")
    private String token;
}
