package com.bluecloudes.algo;

import java.util.Arrays;
import java.util.Iterator;


public class ChangeMakingProblem {

	/**
	 * Recursive Dynamic programming solution
	 * 
	 * @param coins
	 * @param r
	 * @param amount 
	 * @return
	 */
	public int byRecursive(int[] coins, int amount) {
		System.out.println("Performing ChangeMakingProblem byRecursive");
		System.out.println("Coins : "+Arrays.toString(coins));
		System.out.println("Amount : "+amount);
		int result = byRecursive(coins, coins.length-1, amount);
		System.out.println("Result : " + result);
		return result;
	}
	private int byRecursive(int[] coins, int r, int amount) {
		if(amount == 0) {
			return 0;
		}
		
		if(r < 0 && amount > 0){
			return -1;
		}
		
		if(amount < 0) {
			return -1;
		}

		int withR = byRecursive(coins, r, amount-coins[r]);
		int withOutR = byRecursive(coins, r-1, amount);
		if(withR == -1 && withOutR == -1) {
				return -1;
		}
		if(withR == -1 && withOutR != -1) {
			return withOutR;
		}
		if(withR != -1 && withOutR == -1) {
			return 1 + withR;
		}
			
		return Math.min(1+ withR, withOutR);
	}
	
	public int byDp(int[] coins, int amount) {
		if(coins.length < 1) {
			return 0;
		}
		int[] dp = new int[amount+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		for(int coin:coins) {
			for (int i = coin; i <= amount; i++) {
				System.out.println(i+"."+Arrays.toString(dp));
				dp[i] = Math.min(dp[i], (dp[i-coin]==Integer.MAX_VALUE)?Integer.MAX_VALUE:1+dp[i-coin]);
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = {2};
		int amount = 3;
		ChangeMakingProblem problem = new ChangeMakingProblem();
		System.out.println(problem.byDp(coins, amount));
	}
	
	public int byDyanamicProgramming(int[] coins, int cash) {
		System.out.println("Performing ChangeMakingProblem byDyanamicProgramming");
		System.out.println("Coins : "+Arrays.toString(coins));
		System.out.println("Amount : "+cash);
		
		int[][] matrix = new int[coins.length][cash+1];
		for (int i = 0; i < coins.length; i++) {
			matrix[i][0] = 0;
		}
		for (int r=0; r<coins.length; r++) {
			for (int amount = 1; amount < cash+1; amount++) {
				int withR, withOutR;
				if(amount - coins[r] < 0) {
					withR = -1;
				} else {
					withR = matrix[r][amount - coins[r]];
				}
				if(r-1 < 0) {
					withOutR = -1;
				} else {
					withOutR = matrix[r-1][amount];
				}
				if(withR == -1 && withOutR == -1) {
					matrix[r][amount] = -1;
				} else if(withR == -1 && withOutR != -1) {
					matrix[r][amount] = withOutR;
				} else if(withR != -1 && withOutR == -1) {
					matrix[r][amount] = 1+withR;
				} else {
					matrix[r][amount] = Math.min(1+withR, withOutR);
				}
			}
		}
		int result = matrix[coins.length - 1][cash];
		System.out.println("Result : " + result);
		return result;
	}
	
	
}
