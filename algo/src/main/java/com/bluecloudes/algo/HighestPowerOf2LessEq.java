package com.bluecloudes.algo;

public class HighestPowerOf2LessEq {
	private int n;
	public HighestPowerOf2LessEq(int n) {
		this.n = n;
	}
	public int solve() {
		int i = 0;
		int number = n;
		while(number > 0) {
			number = number >> 1;
			i++;
		}
		return 1 << ((i==0)?0:(i-1)) ;
	}
	
	public static void main(String[] args) {
		HighestPowerOf2LessEq problem = new HighestPowerOf2LessEq(19);
		System.out.println(problem.solve());
	}
}
