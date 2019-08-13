package com.tony.spring.exam;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int[] arr;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new int[num];
        for (int i = 0; i < num; i++) {
            int num1 = sc.nextInt();
            arr[i] = num1;
        }
        int minFromArr = getMinFromArr(arr);
        System.out.println(minFromArr);
    }

    /**
     * 获取最小返回值
     *
     * @param arr
     * @return
     */
    public static int getMinFromArr(int[] arr) {
        //如何最小
        //x1 x2 x3 x4
        //(x1+x2)-(x2+x3)
        //最大值
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int[] result = new int[arr.length / 2];
        int j = 0;
        for (; start < end; ) {
            result[j] = arr[start] + arr[end];
            start++;
            end--;
            j++;
        }
        Arrays.sort(result);
        return result[result.length - 1] - result[0];
    }
}
