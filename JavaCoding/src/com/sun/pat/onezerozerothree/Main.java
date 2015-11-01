package com.sun.pat.onezerozerothree;
import java.util.Scanner;
public class Main{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int a,b;
		a=cin.nextInt();
		b=cin.nextInt();
		int[] result=new int[b-a+1];
		int number=2;
		int count=0;
		while(true)
		{
			if(checkPrime(number))
			{
				count++;
				if(count>=a&&count<=b)
				{
					result[count-a]=number;
				}
				if(count>b)
				{
					break;
				}
			}
			number++;
		}
		printResult(result);
	}
	public static boolean checkPrime(int number)
	{
		int count=(int) Math.sqrt(number);
		boolean result=true;
		while(count>1)
		{
			if(number%count==0)
			{
				result=false;
				break;
			}
			count--;
		}
		return result;
	}
	public static void printResult(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(i%10==9)
			{
				System.out.print(a[i]+"\n");
			}else
			{
				System.out.print(a[i]+" ");
			}
		}
		System.out.print(a[a.length-1]);
	}
}