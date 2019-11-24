package com.rainbow.tony.test.concurrent;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    int a = 0;

    public void write() {
        lock.writeLock();
        lock.readLock();
        a++;
        lock.readLock();
    }

    public int read() {
        return a;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuffer s = new StringBuffer();
    }
}
