package com.sun.leetCode;

import java.math.BigDecimal;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(Integer.MIN_VALUE));
		
	}

	public static int reverse(int x){
		BigDecimal b=null;
		if(x>=0){
			StringBuffer str=new StringBuffer(Integer.toString(x));
			str=str.reverse();
			b=new BigDecimal(str.toString().toCharArray());
		}else{
			StringBuffer str=new StringBuffer(String.valueOf(x).substring(1, String.valueOf(x).length()));
			str=str.reverse();
			b=new BigDecimal(str.toString().toCharArray()).negate();
		
		}
		if(b.compareTo(new BigDecimal(Integer.MAX_VALUE))>0||b.compareTo(new BigDecimal(Integer.MIN_VALUE))<0)
		{
			return 0;
		}
		return b.intValue();
	}
}
