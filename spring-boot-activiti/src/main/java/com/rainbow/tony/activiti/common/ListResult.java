package com.rainbow.tony.activiti.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author tony
 * @describe ListResult
 * @date 2019-08-31
 */
@Data
@Accessors(chain = true)
public class ListResult<T> {
    private String message;
    private boolean success;
    private List<T> data;
    private int code;

}
