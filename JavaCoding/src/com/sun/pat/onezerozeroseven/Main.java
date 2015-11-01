package com.sun.pat.onezerozeroseven;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		String strDividend=cin.next();
		int strdivisor=cin.nextInt();
		cin.close();
		BigDecimal dividend=new BigDecimal(strDividend);
		BigDecimal divisor=new BigDecimal(strdivisor);
		BigDecimal[] result=dividend.divideAndRemainder(divisor);
		System.out.println(result[0].toString()+" "+result[1].toString());
		
	}
}