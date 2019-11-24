package com.tony.common.ks.other2;

import java.util.Scanner;

public class Main2 {
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) > m) {
                    count++;
                }
            }
        System.out.println(count);
    }
}
