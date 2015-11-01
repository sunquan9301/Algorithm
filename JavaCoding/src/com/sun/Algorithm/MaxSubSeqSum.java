package com.sun.Algorithm;

public class MaxSubSeqSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int getResult(int a[])
	{
		int maxSum=0;
		int thisSum=0;
		for (int i = 0; i < a.length; i++) {
			thisSum+=a[i];
			if(thisSum>maxSum)
			{
				maxSum=thisSum;
			}else if(thisSum<0){
				thisSum=0;
			}
		}
		return maxSum;
	}
	
	
}
