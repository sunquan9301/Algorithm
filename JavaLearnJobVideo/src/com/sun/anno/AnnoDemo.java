package com.sun.anno;

public class AnnoDemo {
  
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//��ȡ���ϵ�ע��
		Class clazz = (Demo.class);
		//System.out.println(clazz.get);
		MyAnno anno = (MyAnno)clazz.getAnnotation(MyAnno.class);
		System.out.println(anno.name().qq());
		
		//��ȡ�����ϵ�ע��
		
	}

}
