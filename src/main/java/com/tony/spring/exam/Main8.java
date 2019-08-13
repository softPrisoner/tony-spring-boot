package com.tony.spring.exam;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        //算距离变量
        int[] distance = new int[n];
        int flag = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                array[j] = flag;
                j++;
                flag = 0;
            } else {
                flag++;
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (k > distance[i]) {

            }
        }
    }

}
