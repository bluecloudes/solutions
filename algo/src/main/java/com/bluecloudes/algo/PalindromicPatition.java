package com.bluecloudes.algo;

import java.util.Arrays;

public class PalindromicPatition {
	public static int count(char[] chars) {
	int[][] T = new int[chars.length][chars.length];
	int j=0;
	int min = Integer.MAX_VALUE;
	int tValue = 0;
	for(int gap=1;gap<chars.length;gap++) {
		for(int i=0;i+gap<chars.length;i++) {
			j = i+gap;
			min = Integer.MAX_VALUE;
			if(chars[i] == chars[j] && T[i+1][j-1]==0) {
				T[i][j] = 0;
			} else {
				
				for(int k=i;k<i+gap;k++) {
					min = Math.min(min, 1+T[i][k]+T[k+1][j]);
					System.out.println("("+i+","+k+","+j+")");
				}
				T[i][j]=min;
			}
			print(T);
		}
	}
	return T[0][chars.length-1];
	}
	public static void print(int[][] T) {
		System.out.println("T");
		for (int i = 0; i < T.length; i++) {
			System.out.println(Arrays.toString(T[i]));
		}
	}
	public static void main(String[] args) {
		System.out.println(count("abcbm".toCharArray()));
	}
}
