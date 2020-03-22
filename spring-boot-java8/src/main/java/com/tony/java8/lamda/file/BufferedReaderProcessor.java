package com.tony.java8.lamda.file;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author tony
 * @description BufferedReaderProcess
 * @copyright rainbow
 * @date 2020/03/22
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
