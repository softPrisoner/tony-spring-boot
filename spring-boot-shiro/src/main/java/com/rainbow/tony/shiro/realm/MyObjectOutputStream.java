package com.rainbow.tony.shiro.realm;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author tony
 * @describe MyObjectOutputStream
 * @date 2019-08-22
 */
public class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
