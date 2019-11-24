package com.tony.common.proxy.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author tony
 * @describe ReflectTest
 * @date 2019-08-23
 */
@Data
@ToString
@AllArgsConstructor
public class ReflectTest {
    private long id;
    private String name;
    private String password;

}
