package com.rainbow.tony.activiti.common;

/**
 * 日志切面业务枚举类
 *
 * @author tony
 * @describe Dictionary
 * @date 2019-10-17
 */
public class Dictionary {
    /**
     * 日志级别
     */
    public enum LogLevel {
        DEBUG("debug", 4),
        INFO("info", 3),
        WARN("warn", 2),
        ERROR("error", 1);
        private final String name;
        private final int value;

        LogLevel(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * 访问数据库方式,Read方式只输出日志文件不记录日志表，Write方式输出日志文件且记录日志表.
     */
    public enum AccessType {
        READ, WRITE
    }
}
