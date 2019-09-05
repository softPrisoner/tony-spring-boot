package com.rainbow.tony.shiro.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author tony
 * @describe AccountLoginDTO
 * @date 2019-08-22
 */
@Data
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class AccountLoginDTO implements Serializable {
    private long accountId;
    private String petName;
    private String balance;
}
