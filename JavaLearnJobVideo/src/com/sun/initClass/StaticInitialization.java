package com.sun.initClass;

public class StaticInitialization {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table a=new Table();
	}

}
class Table{
//	static Bowl b=new Bowl(2);
	static int a;
	static Bowl b;
	public Bowl c=new Bowl(3);
	static Bowl d=new Bowl(5);
	static{
		System.out.println("INt:"+a);
		b=new Bowl(2);
		System.out.println("static");
	}
	{
		System.out.println("aaa");
		a=5;
	}
	Table()
	{
		System.out.println("Table");
		System.out.println("Int+DONg:"+a);
	}
}
class Bowl{
	Bowl()
	{
		System.out.println("Bowl");
	}
	Bowl(int a){
		System.out.println(a);
	}
}
