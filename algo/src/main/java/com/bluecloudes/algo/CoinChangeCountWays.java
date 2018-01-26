package com.bluecloudes.algo;

import java.util.Arrays;

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
	
	public int byDp(int[] coins, int amount) {
		
		if(coins.length == 0) {
			return 0;
		}
		
		Arrays.sort(coins);
		
		if(amount < coins[0]) {
			return 0;
		}
		
		int[][] T = new int[coins.length][amount+1];
		
		for (int i = 0; i < T.length; i++) {
			T[i][0]=1;
		}
		
		for (int j = coins[0]; j < amount+1 ; j++) {
			T[0][j] = T[0][j-coins[0]];
		}
		

		for (int i = 1; i < coins.length; i++) {
			for (int j = 0; j < amount+1; j++) {
				if(coins[i] > j) {
					T[i][j] = T[i-1][j] + T[i][j-coins[i]];
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[coins.length-1][amount];
	}
	
	public int byDp2(int[] coins, int amount) {
		
		int dp[] = new int[amount+1];
		
		dp[0] = 1;
		
		for (int coin:coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = dp[j] + dp[j-coin];
			}
		}
		
		return dp[amount];
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
