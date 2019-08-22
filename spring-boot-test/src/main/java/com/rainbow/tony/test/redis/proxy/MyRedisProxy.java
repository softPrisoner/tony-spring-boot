package com.rainbow.tony.test.redis.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyRedisProxy {
    private static List<String> servers = new ArrayList<>();

    static {
        servers.add("");
        servers.add("");
        servers.add("");
        servers.add("");
        servers.add("");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(19999);
        Socket socket;
        while (null != (socket = serverSocket.accept())) {
            while (true) {
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                byte[] request = new byte[1024];
                int index = in.read(request);
                String req = new String(request);
                String split = req.split("\r\n")[3].split("$")[1];
            }
        }

    }
}
