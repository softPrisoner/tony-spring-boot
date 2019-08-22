package com.rainbow.tony.test.ip;

import java.util.HashMap;
import java.util.Hashtable;

public class IpHash {
    public static int hashIndex(String ip) {
        return ip.hashCode() ^ 7;
    }

    public static void main(String[] args) {
        int index = hashIndex("127.0.0.1");
        System.out.println(index);
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        Hashtable<String, String> table = new Hashtable<>();
        table.put(null, "123");
        Thread t = new Thread(() -> {
            // TODO Auto-generated method stub
        });
        t.start();
        Object a = new Object();
        System.out.println(a.hashCode());
        System.out.println(map.get(null));
        System.out.println("aka".hashCode());

    }
}
