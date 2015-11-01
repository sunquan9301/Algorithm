package com.sun.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReflectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, Exception, Exception {
		// TODO Auto-generated method stub
//		MyInter m=new MyInterImp1();
//		m.function();
		
		BufferedReader reader=new BufferedReader(new FileReader("config.txt"));
		String line = reader.readLine();
		Class clazz = Class.forName(line);
		MyInter inter = (MyInter) clazz.newInstance();
		inter.function();
	}

}
