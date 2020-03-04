package com.tony.jpa.entity;

import com.tony.jpa.listener.MyEntityListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础类型对象
 *
 * @author tony
 * @describe BaseEntity
 * @date 2020/02/14
 * @MappedSuperclass Extract the public properties
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, MyEntityListener.class})
public abstract class BaseEntity implements Serializable {
    /**
     * 公共主键
     * GenerationType.IDENTITY 主键由数据库自动生成（主要是自动增长型）
     * GenerationType.AUTO 主键由程序控制
     * GenerationType.TABLE 使用一个特定的数据库表格来保存主键
     * GenerationType.SEQUENCE 根据底层数据库的序列来生成主键，条件是数据库支持序列。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) COMMENT '主键ID'")
    private Integer id;
    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
    private LocalDateTime createTime;

    @LastModifiedDate
    @Column(name = "last_modified", columnDefinition = "datetime COMMENT '最后修改时间'")
    private LocalDateTime lastModified;

    /**
     * 是否删除,用于逻辑删除,或者叫软删除
     */
    @Column(name = "is_removed", columnDefinition = "bit COMMENT '逻辑删除'")
    private Boolean isRemoved = false;
}
