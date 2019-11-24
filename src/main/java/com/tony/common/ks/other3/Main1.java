package com.tony.common.ks.other3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    private final static HashMap<String, UrlInfo> urls = new HashMap<>();


    static class UrlInfo {
        private int count;
        private int everyCount;
        private HashSet<Integer> uids = new HashSet<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            final String[] line = s.split(" ");
            String url = line[0];
            if (url.equals("exit"))
                break;
            Integer uid = Integer.parseInt(line[1]);
            UrlInfo urlInfo;
            //出事阿虎数据
            if ((urlInfo = urls.get(url)) == null) {
                urlInfo = new UrlInfo();
                urlInfo.count = 1;
                urlInfo.everyCount = 1;
                urlInfo.uids.add(uid);
                urls.put(url, urlInfo);
                //相应的数据已经存在
            } else {
                boolean contains = urlInfo.uids.contains(uid);
                urlInfo.everyCount += 1;
                if (!contains) {
                    urlInfo.uids.add(uid);
                    urlInfo.count += 1;
                }
            }

        }
        for (Map.Entry<String, UrlInfo> info : urls.entrySet()) {
            String key = info.getKey();
            UrlInfo val = info.getValue();
            System.out.println("网站地址：" + key + "\r\n访问人数:" + val.count + "\r\n总访问量:" + val.everyCount);
        }

    }
}
