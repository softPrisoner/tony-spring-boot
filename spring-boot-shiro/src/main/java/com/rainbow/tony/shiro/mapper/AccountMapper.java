package com.rainbow.tony.shiro.mapper;

import com.rainbow.tony.shiro.domain.AccountLoginDO;
import com.rainbow.tony.shiro.domain.AccountLoginDTO;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author tony
 * @describe AccountMapper
 * @date 2019-08-22
 */
@Mapper
public interface AccountMapper {

    AccountLoginDTO accountLogin(AccountLoginDO accountLoginDO);
}
