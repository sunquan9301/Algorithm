package com.sun.primitive;

public class Int {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerDemo();
	
	}
 /**
 * int 转为Integer 用Integer.valueof(int)  Integer到int  用intValue() 自动装箱
 * Integer.value of 默认缓存是-128-127.这之间指向一个对象。
 */
private static void IntegerDemo() {
		// TODO Auto-generated method stub
		Integer a=1;
		Integer b=1;
		Integer c=128;
		Integer d=128;
		System.out.println(a==b);
		System.out.println(c==d);
	}

}
