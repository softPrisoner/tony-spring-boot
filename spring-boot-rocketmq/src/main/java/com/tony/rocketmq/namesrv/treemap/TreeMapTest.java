package com.tony.rocketmq.namesrv.treemap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author tony
 * @describe TreeMapTest
 * @date 2019-08-13
 */
public class TreeMapTest {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return -1;
            }
        });
        map.put(1, "张三");
        map.put(4, "孙杨");
        map.put(2, "李四");
        map.put(5, "悟空");
        map.put(3, "王五");
        SortedMap<Integer, String> headMap = map.headMap(3);
        SortedMap<Integer, String> tailMap = map.tailMap(3);
        headMap.values().forEach(System.out::print);
        System.out.println();
        tailMap.values().forEach(System.out::println);
    }

}
