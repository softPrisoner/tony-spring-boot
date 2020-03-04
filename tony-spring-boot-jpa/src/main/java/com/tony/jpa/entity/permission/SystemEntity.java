package com.tony.jpa.entity.permission;

import com.tony.jpa.entity.BaseEntity;
import com.tony.jpa.enums.SwitchEnum;
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
 * @author tony
 * @description SystemEntity
 * @copyright rainbow
 * @date 2020/02/14
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "system_t")
@Where(clause = "remove=false")
@SQLDelete(sql = "update system_t set remove=true,last_modified=now() where id=?")
public class SystemEntity extends BaseEntity {
    /**
     * 系统名称
     */
    @Column(name = "system_cn_name", columnDefinition = "varchar(100) COMMENT '中文名称'")
    private String systemCnName;
    /**
     * 系统英文名称
     */
    @Column(name = "system_en_name", columnDefinition = "varchar(50) COMMENT '英文名称'")
    private String systemEnName;
    /**
     * 系统编码:
     */
    @Column(name = "system_code", columnDefinition = "varchar(50) COMMENT '编码001'")
    private String systemCode;
    /**
     * 备注
     */
    @Column(name = "remark", columnDefinition = "varchar(50) COMMENT '备注'")
    private String remark;
    /**
     * 是否生效
     */
    @Column(name = "is_effect", columnDefinition = "varchar(20) COMMENT '是否生效'")
    private SwitchEnum is_effect;
}
