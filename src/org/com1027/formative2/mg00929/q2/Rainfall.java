/**
 * Rainfall.java
 */
package org.com1027.formative2.mg00929.q2;

/**
 * Defines the properties and behaviour of a Rainfall class, 
 * used to store the rainfall data for each available year.
 * 
 * @author Milen Georgiev
 *
 */
public class Rainfall {
	/**Contains the objects storing the information about each year and its precipitation.*/
	private RainfallYear[] rainfallYears = null;
	
	/**
	 * Constructor. Sets the values of the fields.
	 * @param rainfallYears contains the objects describing each year.
	 */
	public Rainfall(RainfallYear[] rainfallYears) {
		super();
		if(rainfallYears != null && rainfallYears.length > 0) {
			this.rainfallYears = rainfallYears;
		} else {
			throw new IllegalArgumentException("There must be at least one year!");
		}
	}
	
	/**
	 * Calculates the highest mean annual rainfall.
	 * @return the highest mean annual rainfall.
	 */
	public double calculateHighestMeanAnnualRainfall() {
		double highestRainfall = Double.MIN_VALUE;
		
		for (RainfallYear rainfallYear : rainfallYears) {
			if(rainfallYear.calculateMeanRainfall() > highestRainfall) {
				highestRainfall = rainfallYear.calculateMeanRainfall();
			}
		}
		
		return highestRainfall;
	}
	
	/**
	 * Calculates the lowest mean annual rainfall.
	 * @return the lowest mean annual rainfall.
	 */
	public double calculateLowestMeanAnnualRainfall() {
		double lowestRainfall = Double.MAX_VALUE;
		
		for (RainfallYear rainfallYear : rainfallYears) {
			if(rainfallYear.calculateMeanRainfall() < lowestRainfall) {
				lowestRainfall = rainfallYear.calculateMeanRainfall();
			}
		}
		
		return lowestRainfall;
	}
	
	/**
	 * Calculates the mean precipitation of a specific month in all years.
	 * @return The mean precipitation.
	 */
	public double calculateMeanRainfallMonth(Month month) {
		double mean = 0;
		for (RainfallYear rainfallYear : rainfallYears) {
			mean += rainfallYear.getRainfallMonth(month);
		}
		
		return mean / this.rainfallYears.length;
	}
	
	/**
	 * Calculates the mean rainfall for a specific year
	 * @param year For which year.
	 * @return the mean rainfall
	 */
	public double calculateMeanRainfallYear(int year) {
		for (RainfallYear rainfallYear : rainfallYears) {
			if(rainfallYear.getYear() == year) {
				return rainfallYear.calculateMeanRainfall();
			}
		}
		throw new IllegalArgumentException("Year not found!");
	}
	
	/**
	 * @return An array containing all the years stored in the class.
	 */
	public int[] getYears() {
		int[] years = new int[this.rainfallYears.length];
		
		for (int i = 0; i < rainfallYears.length; i++) {
			years[i] = rainfallYears[i].getYear();
		}
		
		return years;
	}
}
