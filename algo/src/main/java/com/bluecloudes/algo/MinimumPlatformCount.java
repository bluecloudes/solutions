package com.bluecloudes.algo;

import java.util.Arrays;

public class MinimumPlatformCount {

	public static int findPlatform(int[] arr, int[] dep) {
        if (arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 1;
        int result = 1;
        int i = 1, j = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] < dep[j]) {
                platforms++;
                i++;
                if (platforms > result) {
                    result = platforms;
                }
            }
            else {
                platforms--;
                j++;
            }
        }
        return result;
    }
}
