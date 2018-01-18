package com.bluecloudes.algo;

public class LongestPalindromSubstring {

	public static void main(String[] args) {
		 
        String str = "for1221991221for";
        System.out.println("Length is: " + 
                                 longestPalSubstr(str));
    }

	private static String longestPalSubstr(String str) {
		boolean[][] palindrom = new boolean[str.length()][str.length()];
		
		int maxLenght = 1;
		
		for (int k = 0; k < palindrom.length; k++) {
			palindrom[k][k] = true;
		}
		
		int startIndex = 0;
		for (int k = 0; k < palindrom.length - 1 ; k++) {
			if(str.charAt(k) == str.charAt(k+1)) {
				palindrom[k][k+1]  = true;
				maxLenght = 2;
				startIndex = k;
			}
		}
		
		for (int i = 3; i <= str.length(); i++) {
			for (int j = 0; j <= palindrom.length-i ; j++) {
				int k = j+i-1;
				if(palindrom[j+1][k-1] && str.charAt(j) == str.charAt(k)){
					palindrom[j][k] = true;
					if(maxLenght < i) {
						maxLenght = i;
						startIndex = j;
					}
				}
			}
			
		}
				
		return str.substring(startIndex, startIndex+maxLenght);
	} 
}
