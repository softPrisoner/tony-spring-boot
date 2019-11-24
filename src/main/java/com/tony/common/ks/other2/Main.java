package com.tony.common.ks.other2;

import java.util.Scanner;

public class Main {
    private static int[] hobbies;

    public static int count(int start, int end, int target) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (hobbies[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hobbies = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            hobbies[i] = sc.nextInt();
        }
        int groupCount = sc.nextInt();
        while (groupCount > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            int result = count(l, r, k);
            System.out.println(result);
            groupCount--;
        }

    }

}