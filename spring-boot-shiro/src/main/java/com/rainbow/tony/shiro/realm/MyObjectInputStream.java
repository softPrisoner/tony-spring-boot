package com.rainbow.tony.shiro.realm;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * @author tony
 * @describe MyObjectInputStream
 * @date 2019-08-22
 */
public class MyObjectInputStream extends ObjectInputStream {
    public MyObjectInputStream(InputStream in) throws IOException {
        super(in);
    }
}
