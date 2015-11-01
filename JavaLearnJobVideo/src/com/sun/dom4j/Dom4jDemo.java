/**
 * 
 */
package com.sun.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author lenovo
 *
 */
public class Dom4jDemo {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		//1. ��ȡdom4j�ж�ȡxml�ĵ��Ķ��� saxReader
		SAXReader reader = new SAXReader();
		File file = new File("stu.xml");
		//2.ͨ���ö�ȡ�����read��������Ҫ������xml�ĵ����������ȡ���ĵ���document����
		Document document = reader.read(file);
		//3.ͨ���ĵ�����document�����Ի�ȡ���ڵ����
		Element rootElement = document.getRootElement();
		//4.ͨ����Ԫ�ض���Ϳ��Զ��ĵ������ݽ��в�����
		System.out.println(rootElement.getName());
	}
	/**
	 * ��ʾԪ�ؽڵ�
	 */
	public static void elementDemo(Document document)
	{
		Element rootElement				=document.getRootElement();
		
	}
}
