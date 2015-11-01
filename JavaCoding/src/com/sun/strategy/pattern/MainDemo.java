/**
 * 
 */
package com.sun.strategy.pattern;

/**
 * @author sun
 * 1.区分变化和非变化，把变化的单独提出出来，封装到别的地方
 * 2.针对接口编程，而不是针对实现编程
 * 3.尽量使用组合（Has-a) 少用集成（is-a)
 * 策略模式概念：
 * 	该模式提供了一个算法簇，把可变的行为封装起来，可以互相替换。使变化的部分对客户是透明的
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
