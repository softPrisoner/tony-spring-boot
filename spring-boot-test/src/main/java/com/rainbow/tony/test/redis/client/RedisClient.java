package com.rainbow.tony.test.redis.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class RedisClient {
    // input stream
    private InputStream reader;
    private OutputStream writer;

    public RedisClient() throws Exception {
        // Socket for redis conn
        Socket socket = new Socket("127.0.0.1", 6379);
        reader = socket.getInputStream();
        writer = socket.getOutputStream();
    }

    public String set(String k, String v) throws Exception {
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        command.append("$").append(k.getBytes().length).append("\r\n");
        command.append(k).append("\r\n");
        command.append("$").append(v.getBytes().length).append("\r\n");
        command.append(v).append("\r\n");
        writer.write(command.toString().getBytes());
        byte[] response = new byte[1024];
        reader.read(response);
        return new String(response);
    }

    public String get(String k) throws Exception {
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("GET").append("\r\n");
        command.append("$").append(k.getBytes().length).append("\r\n");
        writer.write(command.toString().getBytes());
        byte[] response = new byte[1024];
        reader.read(response);
        return new String(response);
    }

    public PipeLine pipelined() {
        return new PipeLine(reader, writer);
    }

    public Subscribe subscribe() {
        return new Subscribe(reader, writer);
    }
}
