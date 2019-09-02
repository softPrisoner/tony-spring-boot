package com.rainbow.tony.activiti.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe PlainResult
 * @date 2019-08-31
 */
@Data
@Accessors(chain = true)
public class PlainResult<T> {
    private String message;
    private boolean success;
    private T data;
    private int code;
}
