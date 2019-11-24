package com.tony.common.ks.other3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> cashes = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        //输入币值
        int find = in.nextInt();
        while (in.hasNextInt()) {
            //输入可以使用的币值
            cashes.add(in.nextInt());
        }
        Collections.sort(cashes, (o1, o2) -> {
            if (o1 >= o2) {
                return -1;
            }
            return 1;
        });
        HashMap<Integer, Integer> map = new HashMap();
        //求最小张
        Iterator iterator = cashes.iterator();
        while (iterator.hasNext()) {
            int next = (int) iterator.next();
            System.out.print(next + "  ");
            int c = find / next;
            if (c != 0) {
                map.put(next, c);
            }
            find = find % next;
            if (find == 0) {
                break;
            }
        }
        if (find != 0) {
            System.out.println("-1");
        } else {
            int zz = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (value != 0) {
                    System.out.print("面值" + key + "元" + "  " + value + "张");
                    zz += value;
                }
            }
            System.out.println();
            System.out.println("最少" + zz + "张");
        }

    }
}
