/**
 * RainfallYear.java
 */
package org.com1027.formative2.mg00929.q1;

/**
 * Defines the properties and behaviour of a class Rainfall, describing
 * a year and the quantity of precipitation for each of its months.
 * 
 * @author Milen Georgiev
 *
 */
public class RainfallYear {
	/**Contains the specific year.*/
	private int year = 0;
	
	/**Contains the precipitation of each month in the specific year*/
	private double[] rainfallMonths = null;
	
	/** The count of months in a year.*/
	private static final double MONTHS_COUNT = 12;
	
	/**
	 * Constructor. Sets the values of the fields.
	 * @param year The specific year
	 * @param rainfallMonths The precipitation of each month. 
	 */
	public RainfallYear(int year, double[] rainfallMonths) {
		super();
		this.year = year;
		if(rainfallMonths != null && rainfallMonths.length == MONTHS_COUNT) {
			boolean areMonthPrecipitationsNonNegative = true;
			for (double rainfallMonth : rainfallMonths) {
				if(rainfallMonth < 0) {
					areMonthPrecipitationsNonNegative = false;
				}
			}
			if(areMonthPrecipitationsNonNegative ==true) {
				this.rainfallMonths = rainfallMonths;
			} else {
				throw new IllegalArgumentException("Month precipitation must be non-negative!");
			}
		} else {
			throw new IllegalArgumentException("Months count must equal " + MONTHS_COUNT + "!");
		}
	}

	/**
	 * @return Which is the year, which the object describes.
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * @param The month whose precipitation is to be returned.
	 * @return The precipitation of the specific month.
	 */
	public double getRainfallMonth(Month month) {
		return this.rainfallMonths[month.getValue()];
	}
	
	/**
	 * Calculates the mean precipitation of the months.
	 * @return The mean precipitation
	 */
	public double calculateMeanRainfall() {
		double mean = 0;
		for (double rainfallMonth : this.rainfallMonths) {
			mean += rainfallMonth;
		}
		return mean / 12;
	}
}
