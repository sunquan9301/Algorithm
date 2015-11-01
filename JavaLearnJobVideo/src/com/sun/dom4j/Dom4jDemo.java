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
		//1. 获取dom4j中读取xml文档的对象 saxReader
		SAXReader reader = new SAXReader();
		File file = new File("stu.xml");
		//2.通过该读取对象的read方法，与要操作的xml文档相关联。获取该文档的document对象
		Document document = reader.read(file);
		//3.通过文档对象document，可以获取根节点对象
		Element rootElement = document.getRootElement();
		//4.通过根元素对象就可以对文档的内容进行操作。
		System.out.println(rootElement.getName());
	}
	/**
	 * 演示元素节点
	 */
	public static void elementDemo(Document document)
	{
		Element rootElement				=document.getRootElement();
		
	}
}
