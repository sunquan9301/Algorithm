package com.sun.leetCode;

import java.awt.Label;

public class ZigZagConver extends Label{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convert("AB", 1);
	}
	public static String convert(String s, int numRows) {
        String result="";
       int strLength = s.length();
        int d=strLength/4;
        int r=strLength%4;	
        int restColumn=r==0?0:1;
        char data[][]=new char[3][d*2+restColumn];
        for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j]='0';
			}
		}
        int i=1;
        int count=0;
        boolean isEven=false;
        while(count<strLength)
        {
        	
        	if(i%2==0)
        	{
        		if(count>=strLength)
        		{
        			break;
        		}
        		data[1][i-2]=s.charAt(count++);
        	}else{
        		for (int j = 2; j >= 0; j--) {
        			if(i-j-1>=0)
        			{
        				if(count>=strLength)
                		{
                			break;
                		}
        				data[j][i-j-1]=s.charAt(count++);
        			}
    			}
        		if(count>=strLength)
        		{
        			break;
        		}
        	}
        		i++;
        }
        for (int i1 = 0; i1 <numRows; i1++) {
			for (int j1 = 0; j1 < data[i1].length; j1++) {
				result+=data[i1][j1]!='0'?data[i1][j1]:"";
			}
		}
        System.out.println(result);
        return result;
    }
}
