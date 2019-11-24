package com.tony.common.ks.other2;

import java.util.Scanner;

public class Main1 {
    private static int[][] chain;

    public static int check(int n, int m, int c) {
        int count = 0;
        int color = 1;
        int index = -1;
        while (color <= c) {

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= c; j++) {
                    if (chain[i][j] == 1) {
                        if (index != -1 && i - index <= m) {
                            count++;
                            continue;
                        }
                        index = i;
                    }
                }
            }
            color++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        chain = new int[n + 1][c + 1];
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            for (int j = 1; j <= num; j++) {
                chain[i][j] = sc.nextInt();
            }
        }
        int check = check(n, m, c);
        System.out.println(check);

    }
}
