/**
 * 
 */
package com.sun.strategy.pattern;

/**
 * @author lenovo
 *
 */
public abstract class Duck {
	public FlyBehavior flyBehavior;
	public QuackBehavior quackBehavior;
	
	public Duck()
	{
		
	}
	public void performFly()
	{
		flyBehavior.fly();
	}
	public void performQuack()
	{
		quackBehavior.quack();
	}
	public void setFlyBehavior(FlyBehavior fly)
	{
		this.flyBehavior=fly;
	}
	public void setQuackBehavior(QuackBehavior quack)
	{
		this.quackBehavior=quack;
	}
	abstract public void display();
	public void swim()
	{
		System.out.println("all duck can swim");
	}
}
