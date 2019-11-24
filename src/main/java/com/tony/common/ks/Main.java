package com.tony.common.ks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> treeNodes = new ArrayList();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input = sc.readLine();
        if (input.trim().equals("None")) {
            System.out.println("True");
            System.exit(0);
        } else {
            String[] numbers = input.split(" ");
            for (int i = 0; i < numbers.length; i++) {
                int ele = Integer.parseInt(numbers[i].trim());
                treeNodes.add(ele);
            }
        }

        boolean is = true;
        for (int j = 0; j < treeNodes.size() - 1; j++) {
            if (2 * j + 1 >= treeNodes.size() || 2 * j + 2 >= treeNodes.size()) {
                break;
            }
            if (treeNodes.get(2 * j + 1) > treeNodes.get(j) || treeNodes.get(2 * j + 2) < treeNodes.get(j)) {
                is = false;
                break;
            }
        }
        if (is) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
