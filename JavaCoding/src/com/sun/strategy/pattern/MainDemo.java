/**
 * 
 */
package com.sun.strategy.pattern;

/**
 * @author sun
 * 1.���ֱ仯�ͷǱ仯���ѱ仯�ĵ��������������װ����ĵط�
 * 2.��Խӿڱ�̣����������ʵ�ֱ��
 * 3.����ʹ����ϣ�Has-a) ���ü��ɣ�is-a)
 * ����ģʽ���
 * 	��ģʽ�ṩ��һ���㷨�أ��ѿɱ����Ϊ��װ���������Ի����滻��ʹ�仯�Ĳ��ֶԿͻ���͸����
 *
 */
public class MainDemo {
	public static void main(String[] args)
	{
		Duck d=new ModelDuck();
		d.performFly();
		d.performQuack();
	}
	
}
