package com.sun.pat.onezeroonetwo;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int sum=cin.nextInt()+cin.nextInt();
		int c=cin.nextInt();
		String result="";
		while(sum>0)
		{
			result=sum%c+result;
			sum=sum/c;
		}
		System.out.println(result);
	}
}
