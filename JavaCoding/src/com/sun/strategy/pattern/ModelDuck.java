package com.sun.strategy.pattern;

public class ModelDuck extends Duck {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("ModelDuck");
	}

	public ModelDuck()
	{
		this.flyBehavior=new FlyNoWay();
		this.quackBehavior=new Quack();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "i am a model duck";
	}
}
