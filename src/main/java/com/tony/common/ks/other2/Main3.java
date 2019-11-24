package com.tony.common.ks.other2;

import java.util.Scanner;

public class Main3 {
    public static int count = 0;

    public static void check(int a, int b, int k, int i) {
        boolean flag = true;
        int num = 0;
        int h = 1;
        int g = 1;
        while (g <= k) {
            int m = (i / h) % 10;
            if (m != a && m != b) {
                return;
            }
            num += m;
            h *= 10;
            g++;

        }
        if (num == a || num == b) {
            count = count + 1;
        }
    }

    public static void beautiful(int a, int b, int k) {
        for (int i = (int) Math.pow(10, k - 1); i < (int) Math.pow(10, k) - 1; i++) {
            check(a, b, k, i);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        beautiful(a, b, k);
    }
}
