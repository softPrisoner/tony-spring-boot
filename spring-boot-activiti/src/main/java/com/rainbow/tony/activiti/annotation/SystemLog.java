package com.rainbow.tony.activiti.annotation;

import com.rainbow.tony.activiti.common.Dictionary;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author tony
 * @describe SystemLog
 * @date 2019-10-17
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SystemLog {
    /**
     * 业务名称
     */
    String businessName() default "";

    /**
     * 功能编号
     */
    String functionCode() default "";

    /**
     * 函数功能名称.
     */
    String functionName() default "";

    /**
     * 访问数据库方式，WRITE-写，READ-读
     */
    Dictionary.AccessType accessType() default Dictionary.AccessType.WRITE;

    /**
     * 输出日志级别
     */
    Dictionary.LogLevel logLevel() default Dictionary.LogLevel.INFO;
}
