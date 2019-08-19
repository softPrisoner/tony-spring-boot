package com.tony.rocketmq.namesrv.net;

/**
 * @author tony
 * @describe IPFormatException
 * @date 2019-08-19
 */
public class IPFormatException extends IllegalArgumentException {
    public IPFormatException(String message) {
        super(message);
    }

    public IPFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
