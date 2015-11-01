package com.sun.leetCode;

import java.util.ArrayList;

public class one {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		int i, j = 0;
		for (i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			boolean find=false;
			for (j = i; j < nums.length; j++) {
				if (temp == nums[j]) {
					find=true;
					break;
				}
			}
			if(find)
			{
				break;
			}
		}
		result[0]=i;
		result[1]=j;
		return result;
	

	}
}
