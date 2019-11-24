package com.tony.common.ks.other2;

import java.util.Arrays;

public class bain {
	public static int analyze(int arr[], int end) {
		if (arr.length < 3) {
			return -1;
		}
		int temp[] = new int[end];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}
		int result=-1;
		Arrays.sort(temp);
		int sum = 0;
		for (int i = 0; i < temp.length-1; i++) {
			sum += temp[i];
		}
		if (sum > temp[temp.length - 1]) {
			return end;
		} else {
			if (end == 2) {
				return -1;
			}
			result= analyze(arr, end - 1);

		}
		return result;

	}
	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 2, 8,6 };
		int analyze = analyze(arr, arr.length);
		System.out.println(analyze);
System.out.println(args[0]);
	}
}
