/**
 * Month.java
 */
package org.com1027.formative2.mg00929.q2;

/**
 * An enum containing each month of the year.
 * 
 * @author Milen Georgiev
 *
 */
public enum Month {
	JANUARY(0),
	FEBRUARY(1),
	MARCH(2),
	APRIL(3),
	MAY(4),
	JUNE(5),
	JULY(6),
	AUGUST(7),
	SEPTEMBER(8),
	OCTOBER(9),
	NOVEMBER(10),
	DECEMBER(11);
	
	/** The value of the month.*/
	private final int value;
	
	private Month(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
