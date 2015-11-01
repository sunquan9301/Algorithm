package com.sun.leetCode;

import java.math.BigDecimal;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("+1"));
	}
	public static int myAtoi(String str)
	{
		if(str.length()==0)
		{
			return 0;
		}
		int i=0;
		if(str.charAt(0)==' ')
		{
			for (i = 0; i < str.length(); i++) {
				if(str.charAt(i)!=' ')
				{
					break;
				}
			}
			str=str.substring(i);
		}
		int j=0;
		for (j = 0; j < str.length(); j++) {
			if(!((str.charAt(j)>='0'&&str.charAt(j)<='9')||str.charAt(j)=='+'||str.charAt(j)=='-'))
			{
				break;
			}
		}
		if(j==0)
		{
			return 0;
		}
		str=str.substring(0, j);
		if(str.length()==1)
		{
			if(str.charAt(0)>='0'&&str.charAt(0)<='9')
			{
				return str.charAt(0)-'0';
			}else{
				return 0;
			}
		}
	
		String subString=str.substring(1);
		if(subString.contains("+")||subString.contains("-"))
		{
			return 0;
		}
		switch(str.charAt(0)){
		case '+':
			return processPositive(str.substring(1));
		case '-':
			return processNegative(str);
		default:
			return processPositive(str);
		}
	}
	private static int processNegative(String str) {
		// TODO Auto-generated method stub
		BigDecimal b=new BigDecimal(str.toCharArray());
		return b.compareTo(new BigDecimal(Integer.MIN_VALUE))<0?Integer.MIN_VALUE:b.intValue();
	}
	private static int processPositive(String substring) {
		// TODO Auto-generated method stub
		System.out.println(substring);
		BigDecimal b=new BigDecimal(substring.toCharArray());
		if(b.compareTo(new BigDecimal(Integer.MAX_VALUE))>0)
		{
			return Integer.MAX_VALUE;
		}else{
			return b.intValue();
		}
	}
}
