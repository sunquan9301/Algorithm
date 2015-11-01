package com.sun.reflect;

public class Person {
	private String name;
	public Person(String name){
		super();
		this.name=name;
	}
//	public Person()
//	{
//		System.out.println("person run");
//	}
	public void show(String a, int b) {
		System.out.println("name="+name+",a="+a+",b="+b);
	};

	private void name() {
	};
}
