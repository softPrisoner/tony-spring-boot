package com.rainbow.tony.test.redis.client;

import java.io.InputStream;
import java.io.OutputStream;

public class PipeLine {
    private InputStream reader;
    private OutputStream writer;

    public PipeLine(InputStream reader, OutputStream writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void set(String k, String v) throws Exception {
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        command.append("$").append(k.getBytes().length).append("\r\n");
        command.append(k).append("\r\n");
        command.append("$").append(v.getBytes().length).append("\r\n");
        command.append(v).append("\r\n");
        writer.write(command.toString().getBytes());
    }

    public String response() throws Exception {
        byte[] response = new byte[1024];
        reader.read(response);
        return new String(response);

    }
}
