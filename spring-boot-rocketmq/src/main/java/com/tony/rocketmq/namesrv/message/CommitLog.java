package com.tony.rocketmq.namesrv.message;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tony
 * @describe CommitLog
 * @date 2019-08-17
 */
public class CommitLog {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> commitLogList=new CopyOnWriteArrayList<>();
        commitLogList.add("123");
        commitLogList.add("456");
        commitLogList.add("789");
        commitLogList.add("123");
        commitLogList.forEach(System.out::println);
        System.out.println(commitLogList.get(0));
    }
}
