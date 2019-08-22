package com.rainbow.tony.test.tomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServer2 {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(80);
            while (true) {
                Socket client = server.accept();
                Thread tr = new Thread(new Handler(client));
                tr.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}