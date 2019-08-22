package com.rainbow.tony.test.redis.client;

import java.io.InputStream;
import java.io.OutputStream;

public class Subscribe {
    private InputStream reader;
    private OutputStream writer;

    public Subscribe(InputStream reader, OutputStream writer) {
        super();
        this.reader = reader;
        this.writer = writer;
    }

    public void subcribe(String topic) throws Exception {
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("$9").append("\r\n");
        command.append("SUBSCRIBE").append("\r\n");
        command.append("$").append(topic.getBytes().length).append("\r\n");
        command.append(topic).append("\r\n");
        writer.write(command.toString().getBytes());
        while (true) {
            //response
            byte[] response = new byte[1024];
            System.out.println(reader.read(response));
            System.out.println(new String(response));
        }

    }
}
