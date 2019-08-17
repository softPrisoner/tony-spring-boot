package com.tony.rocketmq.namesrv.consistenthash;

/**
 * String hahs to long
 *
 * @author tony
 * @describe HashFunction
 * @date 2019-08-13
 */

public interface HashFunction {
    long hash(String key);
}
