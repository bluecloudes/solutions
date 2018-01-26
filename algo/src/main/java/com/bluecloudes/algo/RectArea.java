package com.bluecloudes.algo;

import java.util.Stack;

public class RectArea {

	public static int area(int[] hist) {
		if(hist.length ==0)
			return 0;
		
		Stack<Integer> stack = new Stack<>();
		
		int i=0;
		int maxArea = 0;
		
		while(i<hist.length) {
			
			if(stack.empty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i);
				i++;
			} else {
				int tp = stack.peek();
				stack.pop();
				
				int area = hist[tp] * (stack.empty()?i:i-stack.peek()-1);
				
				if(maxArea < area) {
					maxArea = area;
				}
			}
				
			
		}
		
		while(!stack.isEmpty()) {
			int tp = stack.peek();
			stack.pop();
			
			int area = hist[tp] * (stack.empty()?i:i-stack.peek()-1);
			
			if(maxArea < area) {
				maxArea = area;
			}
		}
		
		return maxArea;
		
	}
	
	// Driver program to test above function
    public static void main(String[] args) 
    {
        int hist[] = { 2, 4, 1, 2, 3, 5, 4 };
        System.out.println("Maximum area is " + area(hist));
    }
}
