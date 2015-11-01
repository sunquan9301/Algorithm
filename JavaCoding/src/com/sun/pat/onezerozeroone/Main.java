package com.sun.pat.onezerozeroone;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		ArrayList<Byte> results=new ArrayList<Byte>(10);
		int count;
		long a,b,c;
		byte result;
		count=cin.nextInt();
		while(count>0)
		{
			a=cin.nextLong();
			b=cin.nextLong();
			c=cin.nextLong();
			result=(byte) (a+b>c?1:0);
			results.add(result);
			count--;
		}
		for (int i=0;i<results.size();i++) {
			if(results.get(i)==1)
			{
				System.out.println("Case #"+(i+1)+": true");
			}else
			{
				System.out.println("Case #"+(i+1)+": false");
			}
		}
		cin.close();
	}
}
