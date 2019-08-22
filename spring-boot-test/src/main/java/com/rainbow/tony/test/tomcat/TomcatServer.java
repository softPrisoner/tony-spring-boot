package com.rainbow.tony.test.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println();
            Socket client = server.accept();
            System.out.println("Tomcat wait for request");
            InputStream in = client.getInputStream();
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = buf.readLine()) != null && line.length() > 0) {
                builder.append(line);
                builder.append("\r\n");
            }
            System.out.println(builder.toString());
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
            writer.print("HTTP/1.1 200 OK");
            writer.print("\r\n");
            writer.print("Content-Type: text/html; charset=gbk");
            writer.println("\r\n");
            writer.print("<html><body>html 1314</body></html>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
