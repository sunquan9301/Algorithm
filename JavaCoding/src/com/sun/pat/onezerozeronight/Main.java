package com.sun.pat.onezerozeronight;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		String sourceNumber=cin.nextLine();
		if(sourceNumber.length()<4);
		{
			String s="";
			int count=4-sourceNumber.length();
			while(count>0)
			{
				s+="0";
				count--;
			}
			sourceNumber=s+sourceNumber;
		}
	
		while(!sourceNumber.equals("6174"))
		{
			
			char[] charNum=sourceNumber.toCharArray();
			
			Arrays.sort(charNum);
			if(charNum[0]==charNum[charNum.length-1])
			{
				System.out.println(sourceNumber+" - "+sourceNumber+" = 0000");
				break;
			}
			String subtrahend=charToString(charNum);

			String minuend=new StringBuffer(subtrahend).reverse().toString();
			sourceNumber=Integer.toString(Integer.parseInt(minuend)-Integer.parseInt(subtrahend));
			System.out.println(minuend+" - "+subtrahend+" = "+sourceNumber);
			
		}
	}
	private static String charToString(char[] charNum) {
		// TODO Auto-generated method stub
		String s="";
		for (int i = 0; i < charNum.length; i++) {
			s+=charNum[i];
		}
		return s;
	}
}