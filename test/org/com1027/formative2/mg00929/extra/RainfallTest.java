/**
 * RainfallTest.java
 */

package org.com1027.formative2.mg00929.extra;

import static org.junit.Assert.assertEquals;

import org.com1027.formative2.mg00929.extra.Month;
import org.com1027.formative2.mg00929.extra.Rainfall;
import org.junit.Test;

/**
 * Tests for the <code>Rainfall</code> class.
 * 
 * @author Matthew Casey
 */
public class RainfallTest {

  /**
   * Test object construction.
   */
  @Test
  public void testConstruction() {
    // Use the rainfall file extracted from Met Office (2008). England & Wales Rainfall (mm).
    // http://www.metoffice.gov.uk/climate/uk/seriesstatistics/ewrain.txt. [Accessed 17-10-2011.]
    Rainfall rainfall = new Rainfall("rain.txt");

    // Test that all of the years have been loaded: 1914 to 2008.
    int[] years = rainfall.getYears();

    for (int i = 0; i < years.length; i++) {
      assertEquals("Incorrect year", 1914 + i, years[i]);
    }
  }

  /**
   * Test calculation of the mean rainfall over a month for all years.
   */
  @Test
  public void testMonth() {
    // Use the rainfall file extracted from Met Office (2008). England & Wales Rainfall (mm).
    // http://www.metoffice.gov.uk/climate/uk/seriesstatistics/ewrain.txt. [Accessed 17-10-2011.]
    Rainfall rainfall = new Rainfall("rain.txt");

    // Test that the mean rainfall for a month is correct: for January over all years, the mean is 90.75.
    assertEquals("Incorrect mean rainfall for a month", 90.75, rainfall.calculateMeanRainfallMonth(Month.JANUARY), 0.01);
  }

  /**
   * Test calculation of the mean rainfall over a year.
   */
  @Test
  public void testYear() {
    // Use the rainfall file extracted from Met Office (2008). England & Wales Rainfall (mm).
    // http://www.metoffice.gov.uk/climate/uk/seriesstatistics/ewrain.txt. [Accessed 17-10-2011.]
    Rainfall rainfall = new Rainfall("rain.txt");

    // Test that the mean rainfall for a year is correct: for 1914 the mean is 80.19.
    assertEquals("Incorrect mean rainfall for a year", 80.19, rainfall.calculateMeanRainfallYear(1914), 0.01);

    // Test that the lowest mean annual rainfall is correct: for 1914 the mean is 80.19.
    assertEquals("Incorrect lowest mean annual rainfall", 53.28, rainfall.calculateLowestMeanAnnualRainfall(), 0.01);

    // Test that the highest mean annual rainfall is correct: for 1914 the mean is 80.19.
    assertEquals("Incorrect highest mean annual rainfall", 99.52, rainfall.calculateHighestMeanAnnualRainfall(), 0.01);
  }
}
