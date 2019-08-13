package com.tony.spring.exam;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] timeUseed = new int[10];
        for (int i = 0; i < 10; i++) {
            timeUseed[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        int B = sc.nextInt();
        //首先如果0位多的话，无论满足哪一个都可以设置为0
        System.out.println(getMultiMin(timeUseed, A, B));
    }

    public static int getMultiMin(int[] timeUsed, int a, int b) {
        if (timeUsed[0] >= a || timeUsed[0] >= b) {
            return 0;
        }
        //下面为0位不不足
        //最小乘以次最小
        //但后面00001 * 5555   00010 * 0055
        int tempA = 0;
        int tempB = 0;
        for (int i = 0; i < timeUsed.length; i++) {
            //高位绝对值最小
            //降位 0001 0002
            int fence = timeUsed[i];
            int max = Math.max(a, b);
            if (max == a)
                max = a;
            while (fence > 0) {
                if (a >= b) {
                    if (a > 0 && fence > 0) {
                        tempA += (int) i * (Math.pow(10, a - 1));
                        a--;
                        fence--;
                    }
                } else if (b > 0 && fence > 0) {
                    tempB += (int) i * (Math.pow(10, b - 1));
                    b--;
                    fence--;
                }
                if (a == 0 && b == 0)
                    break;
            }
            if (a == 0 && b == 0)
                break;
        }
        return tempA * tempB;
    }
}
