package com.tony.java8.log;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Log supported by java8
 *
 * @author tony
 * @description LogUtils
 * @copyright rainbow
 * @date 2020/04/24
 */
public class LogUtils {
    private Logger logger;

    public void log(Level level, Supplier<String> msgSupplier) {
        if (logger.isLoggable(level)) {
            log(level, msgSupplier.get());
        }

    }

    private void log(Level level, String info) {
    }
}
