package com.bluecloudes.algo;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

	public static int length(char[] array) {
		int[][] T = new int[array.length][array.length];
		
		for (int i = 0; i < array.length; i++) {
			T[i][i] = 1;
		}
		
		for (int gap = 1; gap < T.length; gap++) {
			for(int i=0; i+gap <array.length; i++) {
				int j = i+gap;
				if(array[i] == array[j]) {
					T[i][j] = 2+T[i+1][j-1];
				} else {
					T[i][j] = Math.max(T[i][j-1], T[i+1][j]);
				}
				print(T);
			}
		}
		return T[0][array.length-1];		
	}
	
	public static void print(int[][] T) {
		System.out.println("T");
		for (int i = 0; i < T.length; i++) {
			System.out.println(Arrays.toString(T[i]));
		}
	}
	
	public static void main(String[] args) {
		char[] array = "agbdba".toCharArray();
		System.out.println(length(array));
	}
}
