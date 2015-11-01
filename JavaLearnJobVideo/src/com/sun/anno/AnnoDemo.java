package com.sun.anno;

public class AnnoDemo {
  
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//获取类上的注解
		Class clazz = (Demo.class);
		//System.out.println(clazz.get);
		MyAnno anno = (MyAnno)clazz.getAnnotation(MyAnno.class);
		System.out.println(anno.name().qq());
		
		//获取方法上的注解
		
	}

}
