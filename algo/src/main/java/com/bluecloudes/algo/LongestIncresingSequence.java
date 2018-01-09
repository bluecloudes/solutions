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
    public int lengthByDynamicProgramming(int[] list) {
    	
    	System.out.println("Performing LongestIncresingSequence by dynamic programming");
    	System.out.println("input : " + Arrays.toString(list));
    	
    	
    	int[] lenghtTracker = new int[list.length];
    	
    	for (int i = 0; i < lenghtTracker.length; i++) {
			lenghtTracker[i] = 1;
		}
    	
    	for(int i=1; i<list.length; i++) {
    		for(int j=0; j<i;j++) {
    			if(list[j] < list[i]) {
    				lenghtTracker[i] = Math.max(lenghtTracker[i], lenghtTracker[j]+1);
    			}
    		}
    	}
    	int result = Arrays.stream(lenghtTracker).summaryStatistics().getMax();
    	System.out.println("result : " + result);
    	return result;
     }
    
    public int length(int[] list) {
    	
    	System.out.println("Performing LongestIncresingSequence on O(NlogN)");
    	System.out.println("input : " + Arrays.toString(list));
    	
    	if(list.length == 0) {
    		return 0;
    	}
    	
    	int[] sequenceTracker = new int[list.length];
    	
    	sequenceTracker[0] = list[0];
    	int size=1;
    	
    	for (int i = 1; i < list.length; i++) {
			if(list[i] < sequenceTracker[0]) {
				sequenceTracker[0]=list[i];
			} else if(sequenceTracker[size-1] < list[i]) {
				sequenceTracker[size++] = list[i];
			} else {
				sequenceTracker[ceil(sequenceTracker, -1, size-1, list[i])] = list[i];
			}
		}
    	System.out.println("result : " + size);
    	return size;
    }

	private int ceil(int[] sequenceTracker, int i, int j, int value) {
		while(i + 1 < j) {
			int mid = i + (j-i)/2;
			if(sequenceTracker[mid] <= value) {
				i = mid;
			} else {
				j = mid;
			}
		}
		return j;
	}
}
