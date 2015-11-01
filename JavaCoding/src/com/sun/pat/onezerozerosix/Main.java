package com.sun.pat.onezerozerosix;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int DA,DB,A,B;
		DA=cin.nextInt();
		A=cin.nextInt();
		DB=cin.nextInt();
		B=cin.nextInt();
		int PA,PB;
		PA=transfer(DA,A);
		PB=transfer(DB,B);
		System.out.println(PA+PB);
	}

	private static int transfer(int first, int second) {
		// TODO Auto-generated method stub
		char[] result=Integer.toString(first).toCharArray();
		int count=0;
		for (int i = 0; i < result.length; i++) {
			if((result[i]-'0')==second)
			{
				count++;
			}
		}
		String s="";
		for (int i = 0; i < count; i++) {
			s+=second;
		}
		if(s=="")
			return 0;
		return Integer.parseInt(s);
	}
}