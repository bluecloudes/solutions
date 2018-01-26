package com.bluecloudes.algo;

import java.util.Arrays;

public class OptimalStrategyOfGame {

	public int play(int[] array) {
		int T[][] = new int[array.length][array.length];
		for (int gap = 0; gap < array.length; gap++) {
			for(int i=0, j=gap;j<array.length;j++) {
				i = j-gap;
				int x = (i+2 <= j)?T[i+2][j]:0;
				int y = (i+1 <= j-1)?T[i+1][j-1]:0;
				int z = (i <= j-2)?T[i][j-2]:0;
				
				T[i][j] = Math.max(array[i]+Math.min(x,y), array[j]+Math.min(y,z));
				//print(T);
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
		OptimalStrategyOfGame game = new OptimalStrategyOfGame();
		 int array[] = {8, 15, 3, 7};
		 int n = array.length;
		 System.out.println(game.play(array));
		 
		 int array2[] = {2, 2, 2, 2};
		 System.out.println(game.play(array2));
	}
 }
