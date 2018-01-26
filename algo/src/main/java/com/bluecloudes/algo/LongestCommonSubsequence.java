package com.bluecloudes.algo;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public static void main(String[] args)
	  {
	    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
	    String s1 = "ABCDAF";
	    String s2 = "ZBCDF";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +
	                                  lcs.lcs( X, Y) );
	  }

	private int lcs(char[] x, char[] y) {
		int[][] T= new int[x.length+1][y.length+1];
		for (int i = 0; i < T.length; i++) {
			Arrays.fill(T[i], 0);
		}
		for(int i=1; i<=x.length; i++) {
			for(int j=1; j<=y.length;j++) {
				if(x[i-1]==y[j-1]) {
					T[i][j] = T[i-1][j-1]+1;
				} else {
					T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
				}
			}
		}
		return T[x.length][y.length];
	}
	 
}
