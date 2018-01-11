package com.bluecloudes.algo;

public class CoinChangeCountWays {
	public int byRecursion(int[] coins, int amount) {
		int result = byRecursion(coins, coins.length-1, amount);
		return result;
	}
	
	private int byRecursion(int[] coins, int lastCoin, int amount) {
		if(amount == 0) {
			return 1;
		}
		if(lastCoin < 0) {
			return 0;
		}
		if(amount < 0 && lastCoin >= 0) {
			return 0;
		}
		return byRecursion(coins, lastCoin, amount-coins[lastCoin]) + byRecursion(coins,lastCoin-1, amount);
	}
	
		
	public int byDynamicProgramming(int[] coins, int amount) {
		if(coins.length == 0) {
			return 0;
		}
		int[][] matrix = new int[coins.length][amount+1];
		for (int i = 0; i < coins.length; i++) {
			matrix[i][0] = 1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < amount+1; j++) {
				matrix[i][j] = matrix(matrix, i, j-coins[i]) + matrix(matrix, i-1, j);
			}
		}
		return matrix[coins.length-1][amount];
	}
	
	private int matrix(int[][] matrix, int i, int j) {
		if (j < 0) {
			return 0;
		}
		if (i < 0) {
			return 0;
		}
		return matrix[i][j];
		
	}
}
