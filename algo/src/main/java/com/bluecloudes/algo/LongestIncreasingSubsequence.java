package com.bluecloudes.algo;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public int length(int[] givenArray) {
		int[] lis = new int[givenArray.length];
		
		Arrays.fill(lis, 1);
		
		int i = 0;
		int max = 1;
		for (int j = 1; j < lis.length; j++) {
			i = 0;
			while(i<j) {
				if(givenArray[i]<givenArray[j] && lis[i]+1 > lis[j]) {
					lis[j]++;
					if(max < lis[j]) {
						max = lis[j];
					}
				}
				i++;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] givenArray = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis.length(givenArray));
	}
}
