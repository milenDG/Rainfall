/**
 * RainfallTest.java
 */

package org.com1027.formative2.mg00929.extra;

import static org.junit.Assert.assertEquals;

import org.com1027.formative2.mg00929.q1.Month;
import org.com1027.formative2.mg00929.q1.RainfallYear;
import org.junit.Test;

/**
 * Tests for the <code>RainfallYear</code> class.
 * 
 * @author Matthew Casey
 */
public class RainfallYearTest {

  /**
   * Test object construction.
   */
  @Test
  public void testConstruction() {
    // Create an object with a line to parse.
    RainfallYear rainfallYear = new RainfallYear(2009, new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 });

    // Test that the correct values have been extracted.
    assertEquals("Incorrect year", 2009, rainfallYear.getYear());

    for (int i = 0; i < 12; i++) {
      assertEquals("Incorrect rainfall", i, rainfallYear.getRainfallMonth(Month.values()[i]), 0);
      System.out.println(Month.values()[i] + ": " + i + " == " + rainfallYear.getRainfallMonth(Month.values()[i]));
    }
  }

  /**
   * Test calculation of the mean rainfall.
   */
  @Test
  public void testMeanRainfall() {
    // Create an object with a line to parse.
    RainfallYear rainfallYear = new RainfallYear(2009, new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 });

    // Test that the mean is correct.
    double expectedMean = (0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / (double) 12;
    assertEquals("Incorrect mean", expectedMean, rainfallYear.calculateMeanRainfall(), 0);
  }
}
