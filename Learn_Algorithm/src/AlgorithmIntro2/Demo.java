package AlgorithmIntro2;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args)
	{
		Scanner in =new Scanner(System.in);
		String str=in.nextLine();
		processStr(str);
		in.close();
	}

	private static void processStr(String str) {
		// TODO Auto-generated method stub
		char[] c=str.toCharArray();
		int maxLength=0;
		int maxStart=0;
		int maxEnd=0;
		int length=0;
		int startIndex=0;
		if(Character.isDigit(c[0]))
		{
			startIndex=0;
			length=1;
		}
		for (int i = 1; i < c.length; i++) {
			if(Character.isDigit(c[i]))
			{
				length++; 
				if(!Character.isDigit(c[i-1]))	
				{
					startIndex=i;
				}
				if((i==c.length-1)||!Character.isDigit(c[i+1]))
				{
					if(length>maxLength)
					{
						maxLength=length;
						maxStart=startIndex;
						maxEnd=i;
					}
					if(length==maxLength)
					{
						int maxSum=0;
						for (int j = maxStart; j < maxEnd; j++) {
							maxSum+=(int)(c[j]-'0');
						}
						int nowSum=0;
						for (int j = startIndex; j < i; j++) {
							nowSum+=(int)(c[j]-'0');
						}
						if(nowSum>maxSum)
						{
							maxLength=length;
							maxStart=startIndex;
							maxEnd=i;
						}
					}
					length=0;
				}
			}
		}
		String result="";
		for (int i = maxStart; i <=maxEnd ; i++) {
			result+=c[i];
		}
		System.out.println(result);
	}
}
