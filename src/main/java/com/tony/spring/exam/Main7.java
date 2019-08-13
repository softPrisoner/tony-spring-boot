package com.tony.spring.exam;

import java.util.Scanner;

public class Main7 {
    static int total = 1;

    public static void compute(int n, int k) {
        if (k > n)
            return;
        if (k >= 3 && k <= 7) {
            total += 1;
            compute(n - k + 1, 1);
        }
        if (k <= 10) {
            compute(n, k + 1);
        } else {
            //.....
            total -= 1;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        compute(n, 1);
        System.out.println(total);
    }
}
