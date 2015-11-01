package com.sun.pat.onezerozerotwo;
import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int[][] result=new int[5][2];
		int count,a;
		count=cin.nextInt();
		while(count>0)
		{
			a=cin.nextInt();
			if((a%5==0)&&(a%2==0))
			{
				result[0][0]++;
				result[0][1]+=a;
			}
			if(a%5==1)
			{
				result[	1][0]++;
				if(result[1][0]%2==0)
				{
					result[1][1]-=a;
				}else{
					result[1][1]+=a;
				}
			}
			if(a%5 == 2)
			{
				result[2][0]++;
			}
			if(a%5 == 3)
			{
				result[3][0]++;
				result[3][1]+=a;
			}
			if(a%5==4)
			{
				result[4][0]++;
				if(a>result[4][1])
				{
					result[4][1]=a;
				}
			}
			count--;
		}
		cin.close();
		if(result[0][0]==0)
		{
			System.out.print("N ");
		}else
		{
			System.out.print(result[0][1]+" ");
		}
		if(result[1][0]==0)
		{
			System.out.print("N ");
		}else
		{
			System.out.print(result[1][1]+" ");
		}
		if(result[2][0]==0)
		{
			System.out.print("N ");
		}else
		{
			System.out.print(result[2][0]+" ");
		}
		if(result[3][0]==0)
		{
			System.out.print("N");
		}else
		{
			System.out.printf("%.1f",(float)(result[3][1])/((float)(result[3][0])));
		}
		if(result[4][0]==0)
		{
			System.out.print(" N");
		}else
		{
			System.out.print(" "+result[4][1]);
		}
	}
}
