package com.rainbow.tony.shiro.chapter6;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tony
 * @describe Role
 * @date 2019-09-07
 */
@Data
@ToString
@NoArgsConstructor
public class Role {

    private long id;
    private String name;
    private String description;
    private Set<String> permissions = new HashSet<>();
}
