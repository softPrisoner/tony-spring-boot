package com.rainbow.tony.test.tomcat;

import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {
    private final Socket client;

    public Handler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = client.getInputStream();
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = buf.readLine()) != null && line.length() > 0) {
                builder.append(line);
                builder.append("\r\n");
            }
            System.out.println(builder.toString());
            String webRoot = "/tony/web/tomcat";
            String[] res = builder.toString().split(" ");
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
            writer.print("HTTP/1.1 200 OK");
            writer.print("\r\n");
            writer.print("Content-Type:text/html;charset=utf-8");
            writer.println();
            writer.flush();
            if (res.length >= 2) {
                String path = webRoot + res[1];
                FileInputStream fin = new FileInputStream(new File(path));
                byte[] b = new byte[1024];
                int len;
                while ((len = fin.read(b)) != -1) {
                    out.write(b, 0, len);
                    out.flush();
                }
                fin.close();
                out.close();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
