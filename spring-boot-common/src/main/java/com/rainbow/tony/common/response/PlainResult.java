package com.rainbow.tony.common.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe PlainResult
 * @date 2019-08-22
 */
@Data
@Accessors(chain = true)
public class PlainResult<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
}
