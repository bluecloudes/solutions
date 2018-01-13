package com.bluecloudes.algo;

/**
 * https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
 * @author savankumar.gudaas
 *
 */
public class CountSetBitsFrom1toN {

	int n;
	public CountSetBitsFrom1toN(int n) {
		super();
		this.n = n;
	}

	public int count() {
		if(n <= 0) {
			return 0;
		}
		int i=0;
		int number = n;
		int count = 0;
		while(number > 0) {
			int setBit = number & 1;
			if(setBit == 1)
				count += (i==0)?1:(1 + i *(1<<(i-1)));
			i++;
			number>>=1;
			
		}
		if(n>1)
			count = count + (n- (1<<(i-1)));
		return count;
 	}
	
	public static void main(String[] args) {
		CountSetBitsFrom1toN problem = new CountSetBitsFrom1toN(17);
		System.out.println(problem.count());
	}
}
