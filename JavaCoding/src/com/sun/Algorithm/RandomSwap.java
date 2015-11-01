package com.sun.Algorithm;

import java.util.Arrays;
import java.util.Random;

public class RandomSwap {
	public static int N=50000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long a=System.currentTimeMillis();
//		int[] result=random1(N);
//		//System.out.println(Arrays.toString(result));
//		long b=System.currentTimeMillis();
//		int[] result1=random2(N);
//	//System.out.println(Arrays.toString(result1));
		long c=System.currentTimeMillis();
		int[] result2=random3(N);
		//System.out.println(Arrays.toString(result2));
		long d=System.currentTimeMillis();
		//System.out.println("1: "+(b-a)+"\n"+"2: "+(c-b)+"\n"+"3: "+(d-c));
		System.out.println(d-c);
	}
	public static int[] random1(int N)
	{
		Random a=new Random();
		int[] result=new int[N];
		for (int i = 0; i < result.length; i++) {
			while(true){
				int temp=a.nextInt(N);
				if(!isInArray(result,temp,i))
				{
					result[i]=temp;
					break;
				}
			}
		}
		return result;
	}
	public static int[] random2(int N)
	{
		int[] result=new int[N];
		int[] useNum=new int[N];
		Random a=new Random();
		for (int i = 0; i < result.length; i++) {
			while(true)
			{
				int temp=a.nextInt(N	);
				if(useNum[temp]==0)
				{
					result[i]=temp;
					useNum[temp]=1;
					break;
				}
			}
		}
		return result;
	}
	private static boolean isInArray(int[] arr,int temp,int i) {
		// TODO Auto-generated method stub
		boolean result=false;
		for (int j = 0; j < i; j++) {
			if(temp==arr[j])
			{
				result=true;
				break;
			}
		}
		return result;
	}
	private static int[] random3(int N)
	{
		Random ran=new Random();
		int[] result=new int[N];
		for (int i = 0; i < result.length; i++) {
			result[i]=i;
		}
		for (int i = 1; i < result.length; i++) {
			swap(result,i,ran.nextInt(i));
		}
		return result;
	}
	private static void swap(int[] result, int i, int nextInt) {
		// TODO Auto-generated method stub
		result[i]=result[i]^result[nextInt];
		result[nextInt]=result[i]^result[nextInt];
		result[i]=result[i]^result[nextInt];
	}
}
