package com.tony.spring.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void compute(int count, int orgin, int target) {
        if (orgin == target) {
            list.add(count);
            return;
        }
        if (orgin > 0 && target < 0) {
            int abs = Math.abs(orgin) + 1;
            compute(count + abs, -1, target);
        } else if (orgin < 0 && target > 0) {
            int abs = Math.abs(orgin) + 1;
            compute(count + abs, 1, target);
        } else if (orgin < target) {
            compute(count + 1, orgin * 2, target);
            compute(count + 1, orgin + 1, target);
        } else if (orgin > target) {
            compute(count + 1, orgin - 1, target);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] split = next.split(",");
        int orgin = Integer.parseInt(split[0]);
        int target = Integer.parseInt(split[1]);
        compute(0, orgin, target);
        Collections.sort(list);
        System.out.println(list.get(0));

    }

}