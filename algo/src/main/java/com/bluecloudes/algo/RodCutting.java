package com.bluecloudes.algo;

import java.util.Arrays;

public class RodCutting {
	public static int cut(int[] costs,  int length) {
		int[] dp = new int[length+1];
		System.out.println(Arrays.toString(dp));
		for(int i=0;i<costs.length;i++) {
			for(int j=i+1; j<=length; j++) {
				dp[j] = Math.max(dp[j], costs[i]+dp[j-(i+1)]);
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[length];
	}
	
	public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                            cut(arr, size));
    }
}
