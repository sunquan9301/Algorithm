package com.sun.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) throws Exception
	{
		Class cla=Class.forName("com.sun.reflect.Person");
		
		
		Method[] methods=cla.getDeclaredMethods();
		for(Method method:methods)
		{
			System.out.println(method);
		}
		
		Constructor constructor=cla.getConstructor(String.class);
		Person p=(Person) constructor.newInstance("zhang san");
	//	Person p=(Person)cla.newInstance();
		Method method=cla.getMethod("show", String.class,int.class);
		method.invoke(p, "haha",45);
	}

}
