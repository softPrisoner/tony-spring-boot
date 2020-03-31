package com.tony.properties.annotations;

import java.lang.annotation.*;

/**
 * @author tony
 * @description Arg
 * @copyright rainbow
 * @date 2020/03/31
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(ConstructorArgs.class)
public @interface Arg {


}
