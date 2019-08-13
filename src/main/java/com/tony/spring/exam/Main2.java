package com.tony.spring.exam;

import java.util.Scanner;

public class Main2 {
    private static int count = 0;
    private int temp;

    public static int getResult(int pNumber) {
        if (pNumber > 6) {
            pNumber--;
            count++;
            return count + getResult(pNumber);
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //人数
        int pNumber = sc.nextInt();
        System.out.println(getResult(pNumber));

    }
}
