package com.rainbow.tony.activiti.annotation;

import com.rainbow.tony.activiti.common.Dictionary;

import java.lang.annotation.*;

/**
 * ϵͳ��־ע��
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
     * ҵ������
     */
    String businessName() default "";

    /**
     * ���ܱ��
     */
    String functionCode() default "";

    /**
     * ������������.
     */
    String functionName() default "";

    /**
     * �������ݿⷽʽ��WRITE-д��READ-��
     */
    Dictionary.AccessType accessType() default Dictionary.AccessType.WRITE;

    /**
     * �����־����
     */
    Dictionary.LogLevel logLevel() default Dictionary.LogLevel.INFO;
}
