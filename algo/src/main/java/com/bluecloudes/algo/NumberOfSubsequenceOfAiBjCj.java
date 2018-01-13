package com.bluecloudes.algo;

/**
 * https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 * 
 * @author blue
 *
 */
public class NumberOfSubsequenceOfAiBjCj {
	char[] chars;
	public NumberOfSubsequenceOfAiBjCj(String chars) {
		this.chars = chars.toCharArray();
	}
	
	public int count() {
		int countA = 0, countB=0, countC=0;
		for (int i = 0; i < chars.length; i++) {
			
			if(chars[i] == 'a') {
				countA = 1 + 2*countA;
			} else if(chars[i] == 'b') {
				countB = countA + 2*countB;
			} else if(chars[i] == 'c') {
				countC = countB + 2*countC;
			}
			
		}
		return countC;
	}
	
	public static void main(String[] args) {
		NumberOfSubsequenceOfAiBjCj problem = new NumberOfSubsequenceOfAiBjCj("abcabc");
		
		System.out.println(problem.count());
	}
}
