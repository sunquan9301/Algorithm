package com.sun.pat.onezerozerofour;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		String[] DAY={"MON","TUE","WED","THU","FRI","SAT","SUN"};
		String[] TIME={"10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
		Scanner cin=new Scanner(System.in);
		String a,b,c,d;
		a=cin.next();
		b=cin.next();
		c=cin.next();
		d=cin.next();
		cin.close();
		int count=0;
		char[] result=new char[2];
		int index=-1;
		boolean checkChar=true;
		for (int i = 0; i < a.toCharArray().length; i++) 
		{
			if(checkChar)
			{
				if(a.toCharArray()[i]==b.toCharArray()[i]&&a.toCharArray()[i]>='A'&&a.toCharArray()[i]<='Z')
				{
					result[count]=a.toCharArray()[i];
					count++;
					checkChar=false;
				}
			}else
			{
				if(a.toCharArray()[i]==b.toCharArray()[i]&&((a.toCharArray()[i]>='0'&&a.toCharArray()[i]<='9')||(a.toCharArray()[i]>='A'&&a.toCharArray()[i]<='N')))
				{
					result[count]=a.toCharArray()[i];
					count++;
				}
			}
			if(count==2)
			{
				break;
			}
		}
		for (int i = 0; i < c.toCharArray().length; i++) 
		{
			if(c.toCharArray()[i]==d.toCharArray()[i]&&((c.toCharArray()[i]>='A'&&c.toCharArray()[i]<='Z')||(c.toCharArray()[i]>='a'&&c.toCharArray()[i]<='z')))
			{
				index=i;
				break;
			}
		}
		String s=DAY[(int)(result[0]-'A')]+" ";
		s+=result[1]<'9'?"0"+(result[1]-'0'):TIME[result[1]-'A'];
		s+=":";
		s+=index<10?("0"+index):index;
		System.out.println(s);
	}
}