package com.sun.pat.onezerooneone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		String s=cin.nextLine();
		char[] number=s.toCharArray();
		HashMap<String,Integer> h=new HashMap<String,Integer>();
		for (int i = 0; i <number.length; i++) {
			if(h.get(number[i]+"")==null)
			{
				h.put(number[i]+"",1);
			}else{
				h.put(number[i]+"",h.get(number[i]+"")+1);
			}
		}
		Object[] keys=h.keySet().toArray();
		String[] str=new String[keys.length];
		for (int i = 0; i < keys.length; i++) {
			str[i]=keys[i].toString()+":"+h.get(keys[i].toString());
		}
		Arrays.sort(str);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
