package com.sun.Algorithm;

public class GCD {

	public static void  main(String[] args)
	{
		System.out.println(calGCD(50, 15));
	}
	public static int calGCD(int m,int n)
	{
		while(n!=0)
		{
			int rem=m%n;
			m=n;
			n=rem;
		}
		return m;
	}
}
