package com.rainbow.tony.test.redis;

import com.rainbow.tony.test.redis.client.RedisClient;
import org.junit.Test;

class ManualRedisTest {

    @Test
    public void test() throws Exception {
        RedisClient redis = new RedisClient();
        redis.set("a", "bcd");
        String value = redis.get("a");
        System.out.println(value);
    }
}
