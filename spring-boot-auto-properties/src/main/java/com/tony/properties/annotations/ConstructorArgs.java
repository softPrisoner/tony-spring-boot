package com.tony.properties.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ConstructorArgs
 *
 * @author tony
 * @describe ConstructorArgs
 * @copyright rainbow
 * @date 2020/03/31 上午 10:53
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstructorArgs {
    Arg[] value() default {};
}
