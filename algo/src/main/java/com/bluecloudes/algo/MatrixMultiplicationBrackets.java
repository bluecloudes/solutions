package com.bluecloudes.algo;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/
 * 
 * @author savankumar.gudaas
 *
 */
public class MatrixMultiplicationBrackets {

	public static void main(String args[]) {
		int arr[] = {40, 20, 30, 10, 30};
		MatrixMultiplicationBrackets problem = new MatrixMultiplicationBrackets(arr);
	    int count = problem.matrixChainOrder();
	    System.out.println(count);
	    problem.printPeranthesis(1, 4);
	}

	int[][] matrix;
	int[][] bracket;
	int[] sizes;
	int n, numberOfMatrixs;
	public MatrixMultiplicationBrackets(int sizes[]) {
		this.sizes = sizes;
		n = sizes.length;
		numberOfMatrixs = sizes.length - 1;
		bracket = new int[n][n];
		matrix = new int[n][n];
	}
	
	private int matrixChainOrder() {

		

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 0;
		}
		
		for (int l = 2; l <= numberOfMatrixs; l++) {
			// System.out.println("lenght = "+l);
			for (int i = 1; i <= numberOfMatrixs -l +1; i++) {
				matrix[i][i+l-1] = Integer.MAX_VALUE;
				int j = (i+l-1);
				// System.out.println("Calc ["+i+":"+j+"]");
				for (int k = i; k < i+l -1 ; k++) {
								
					int count = matrix[i][k] + matrix[k+1][i+l-1]+sizes[i-1]*sizes[k]*sizes[j];
					
					if(matrix[i][j] > count) {
						matrix[i][j] = count;
						bracket[i][j] = k;
					}
				}
				
			}
		}
		/**
		 
		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		System.out.println("Brackts Matrix");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(bracket[i]));
		}
		*/
		
		return matrix[1][numberOfMatrixs];
	}
	
	private void printPeranthesis(int start, int end) {
		if(start == end) {
			System.out.print(end);
			return;
		}
		System.out.print("(");
		printPeranthesis(start, bracket[start][end]);
		printPeranthesis(bracket[start][end]+1, end);
		System.out.print(")");
	}
}
