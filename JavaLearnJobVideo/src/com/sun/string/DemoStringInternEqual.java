package com.sun.string;

/**
 * @author lenovo
 *
 */

public class DemoStringInternEqual {
	public static void main(String[] args)
	{
			//internCompaEqual(); //比较==,intern()方法，equal（）方法 
			//StringOOM();
		//用与，或来直接判断值是否相等。
		int a=56;
		System.out.println((a^56));
	}
 private static void StringOOM() {
		// TODO Auto-generated method stub
		String a="b";
		int i=0;
		while(true)
		{
			System.out.println(i++);
			a+="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		}
	}
/**
 * ==对于基本类型来说比较的是值，对于引用类型 比较的是地址
 * intern()对于应用对象来说，会在字符串常亮池中拷贝一个静态常亮。
 * equal()方法比较的是值。
 * b是一个变量。需要分配内存的。因为编译器不知道a是常量的类型还是对象的类型所以不会直接优化成常量而是会分配内存空间
 */
public static void internCompaEqual() {
		String a="a";
		String b=a+"b";
		String c="ab";
		String d=new String(b);
		System.out.println(b.intern()==c.intern());
		System.out.println(b.equals(c));
	}
}
