package com.tony.common.ks.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main6 {
    static int min = Integer.MAX_VALUE;
    static int total = 0;

    static int main() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;
        while (k < n) {
            //首先将所有最小的放到一桶中，记录个数
            int value = sc.nextInt();
            k++;
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        map.forEach((key, value) -> {
            total += value;
            if (min == Integer.MAX_VALUE) {
                min = value;
            } else {
                min = minBetweenNum(value, min);
            }
        });
        return total / min;
    }

    public static int minBetweenNum(int i, int j) {
        if (i % j == 0) {
            return j;
        } else {
            int temp = j;
            j = i % j;
            i = j;
            return minBetweenNum(i, j);
        }
    }

    public static void main(String[] args) {
        int result = main();
        System.out.println(result);
    }
}
