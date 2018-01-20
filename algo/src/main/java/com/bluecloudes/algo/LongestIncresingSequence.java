package com.bluecloudes.algo;

import java.util.Arrays;

/**
 * Longest Increasing Sequence Algorithm
 *
 */
public class LongestIncresingSequence 
{
	
	/**
	 * O(n^2)
	 * 
	 * @param list
	 * @return
	 */
	public int lengthDp(int[] givenArray) {
		int[] lis = new int[givenArray.length];
		
		Arrays.fill(lis, 1);
		
		int i = 0;
		int max = 1;
		for (int j = 1; j < lis.length; j++) {
			i = 0;
			while(i<j) {
				if(givenArray[i]<givenArray[j] && lis[i]+1 > lis[j]) {
					lis[j]++;
					if(max < lis[j]) {
						max = lis[j];
					}
				}
				i++;
			}
		}
		return max;
	}
    
	public int binarySearch(int[] array, int start, int end, int value) {
		
		int mid = start + (end-start)/2;
		//System.out.println("start="+start+", mid="+mid+", end="+end+", value="+value);
		if(start>end) {
			return start;
		}
		if(array[mid] == value) {
			return mid;
		} else if(array[mid] < value){
			return binarySearch(array, mid+1, end, value);
		} else {
			return binarySearch(array, start, mid-1, value);
		}
	}
	

	public int lengthByBinary(int[] array) {
		if(array.length < 1) {
			return 0;
		}
		int length = 1;
		int dp[] = new int[array.length];
		
		dp[0] = array[0];
		
		for(int i=1; i<array.length; i++) {
			int index = binarySearch(dp, 0, length-1, array[i]);
			dp[index] = array[i];
			if(index==length) {
				length++;
			}
		}
		//System.out.println(Arrays.toString(dp));
		return length;
	}
	
	public static void main(String[] args) {
		LongestIncresingSequence lis = new LongestIncresingSequence();
		int[] array = {0,8, 4, 12, 2, 10,6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int length = lis.lengthByBinary(array);
		System.out.println(length);
		int[] givenArray = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis.lengthDp(givenArray));
	}
}
