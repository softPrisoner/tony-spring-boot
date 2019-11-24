package com.tony.common.proxy.cglib;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
    private String username;
    private int age;
}
