package com.tony.rocketmq.namesrv.mapper;

/**
 * @author tony
 * @describe AccountMapper
 * @date 2019-08-19
 */
public interface AccountMapper {
    void getAccountInfoFromDB(String accountId);
}
