package com.rainbow.tony.shiro.chapter6;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe User11
 * @date 2019-09-07
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
    private String userId;
    private String name;
    private String username;
    private String password;
    private int sex;
    private int age;
    private String salt; //设置哟古的初始化的盐
    private String credentialsSalt;

    public static void main(String[] args) {
    }
}
