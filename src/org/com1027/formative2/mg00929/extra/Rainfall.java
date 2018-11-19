/**
 * Rainfall.java
 */
package org.com1027.formative2.mg00929.extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Defines the properties and behaviour of a Rainfall class, 
* used to store the rainfall data for each available year.
* 
* @author Milen Georgiev
*
*/
public class Rainfall {
	/**Contains the objects storing the information about each year and its precipitation.*/
	private List<RainfallYear> rainfallYears = null;
	
	/** The count of entries in a line of a file (1 year + 12 months).*/
	private static final int FILE_ROW_COUNT = 13;
	
	/**
	 * Constructor. Sets the values of the fields.
	 * @param rainfallYears contains the objects describing each year.
	 */
	public Rainfall(List<RainfallYear> rainfallYears) {
		super();
		if(rainfallYears != null && rainfallYears.size() > 0) {
			this.rainfallYears = rainfallYears;
		} else {
			throw new IllegalArgumentException("There must be at least one year!");
		}
	}
	
	/**
	 * Constructor. Sets the values of the fields using a file.
	 * @param fileName The name of the file.
	 */
	public Rainfall(String fileName) {
		super();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    this.rainfallYears = new ArrayList<RainfallYear>();
		    while ((line = br.readLine()) != null) {
		    	String[] entries = line.split(",");
		    	if(entries != null && entries.length == Rainfall.FILE_ROW_COUNT) {
		    		List<Double> rainfallMonths = new ArrayList<Double>();
					for (String entry : entries) {
						rainfallMonths.add(Double.parseDouble(entry));
					}
			    	rainfallYears.add(new RainfallYear(Integer.parseInt(entries[0]), rainfallMonths.subList(1, rainfallMonths.size())));
		    	} else {
		    		throw new IOException("Invalid file: each row must be splittable by ',' and contain exactly 13 entries!!!");
		    	}
		    }
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
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
		
		return mean / this.rainfallYears.size();
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
		int[] years = new int[this.rainfallYears.size()];
		
		for (int i = 0; i < rainfallYears.size(); i++) {
			years[i] = rainfallYears.get(i).getYear();
		}
		
		return years;
	}
	
	/**
	 * Calculates the mean precipitation between two years.
	 * @param year1 the first year
	 * @param year2 the second year
	 * @return the mean between the years
	 */
	public double calculateMeanPrecipitationBetweenTwoYears(int year1, int year2) {
		RainfallYear firstYear = null, secondYear = null;
		for (RainfallYear rainfallYear : rainfallYears) {
			if(rainfallYear.getYear() == year1) {
				firstYear = rainfallYear;
			}
			else if(rainfallYear.getYear() == year2) {
				secondYear = rainfallYear;
			}
		}
		
		return ((firstYear.calculateMeanRainfall() * 12) + (secondYear.calculateMeanRainfall() * 12)) / 2;
	}
}
