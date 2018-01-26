package com.bluecloudes.algo;

import java.util.Arrays;

public class UserDefinedArrayList {

	int[] array;
	int index = -1;
	public UserDefinedArrayList() {
		array = new int[4];
	}
	public void add(int i) {
		index++;
		if(index < array.length) {
			array[index] = i;
		} else {
			int arrayOldLength = array.length;
			int[] newArray = new int[array.length*2];
			for (int j = 0; j < arrayOldLength; j++) {
				newArray[j] = array[j];
			}
			newArray[index] =i;
			array =newArray;
		}
		System.out.println(Arrays.toString(array));
	}
	
	public boolean delete(int i) {
		return false;
	}
	
	public static void main(String[] args) {
		UserDefinedArrayList list = new UserDefinedArrayList();
		for (int i = 1; i <34; i++) {
			list.add(i);
		}
	}
}
