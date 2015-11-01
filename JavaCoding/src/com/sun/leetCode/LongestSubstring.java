package com.sun.leetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abba"));
	}
	public static int lengthOfLongestSubstring(String s) {
		int maxLong=0;
		int length=0;
		int j;
		ArrayList<Character> tempCharacter=new ArrayList<Character>();
		int startIndex=0;
		for (int i = 0; i < s.length(); i++) {
			
			if(!tempCharacter.contains(s.charAt(i)))
			{
				length++;
				tempCharacter.add(s.charAt(i));
			}else{
				if(length>maxLong)
				{
					maxLong=length;
				}
				startIndex=tempCharacter.indexOf(s.charAt(i))+startIndex+1;
				int tempLength=tempCharacter.indexOf(s.charAt(i));
				for (j = 0; j <=tempLength; j++) {
					
					tempCharacter.remove(0);
				}
				length=tempCharacter.size()+1;
				tempCharacter.add(s.charAt(i));
				
			}
		}
		if(length>maxLong)
		{
			return length;
		}
        return maxLong;
    }
}
