package com.rainbow.tony.shiro.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author tony
 * @describe AccountLoginDO
 * @date 2019-08-22
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
public class AccountLoginDO {
    private String username;
    private String password;
}
