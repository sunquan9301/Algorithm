package com.sun.string;

/**
 * @author lenovo
 *
 */

public class DemoStringInternEqual {
	public static void main(String[] args)
	{
			//internCompaEqual(); //�Ƚ�==,intern()������equal�������� 
			//StringOOM();
		//���룬����ֱ���ж�ֵ�Ƿ���ȡ�
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
 * ==���ڻ���������˵�Ƚϵ���ֵ�������������� �Ƚϵ��ǵ�ַ
 * intern()����Ӧ�ö�����˵�������ַ����������п���һ����̬������
 * equal()�����Ƚϵ���ֵ��
 * b��һ����������Ҫ�����ڴ�ġ���Ϊ��������֪��a�ǳ��������ͻ��Ƕ�����������Բ���ֱ���Ż��ɳ������ǻ�����ڴ�ռ�
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
