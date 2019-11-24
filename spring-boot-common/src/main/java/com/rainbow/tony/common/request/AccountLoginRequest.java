package com.rainbow.tony.common.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe Userp
 * @date 2019-08-22
 */
@Data
@Accessors(chain = true)
public class AccountLoginRequest {
    private int requestCode;
    private String userName;
    private String password;
}
