/**
 * 
 */
package com.sun.strategy.pattern;

/**
 * @author lenovo
 *
 */
public class MuteQuack implements QuackBehavior {

	/* (non-Javadoc)
	 * @see com.sun.strategy.pattern.QuackBehavior#quack()
	 */
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("muteQuack");
	}

}
