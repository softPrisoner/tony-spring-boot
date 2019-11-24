package com.example.sharingjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author tony
 * @describe UserEntity
 * @date 2019-09-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity implements Serializable {
    @Id
    private long id;
    @Column(length = 32)
    private String name;
    @Column(length = 16)
    private int age;
}
