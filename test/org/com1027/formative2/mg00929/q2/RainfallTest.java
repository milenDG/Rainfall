/**
 * RainfallTest.java
 */

package org.com1027.formative2.mg00929.q2;

import static org.junit.Assert.assertEquals;

import org.com1027.formative2.mg00929.q2.Month;
import org.com1027.formative2.mg00929.q2.Rainfall;
import org.com1027.formative2.mg00929.q2.RainfallYear;
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
    // data created from the inputted arrays
    //http://www.metoffice.gov.uk/climate/uk/seriesstatistics/ewrain.txt. [Accessed 17-10-2011.]
    RainfallYear [] temp = new RainfallYear[10];
    temp[0] = new RainfallYear(1914, new double []{ 50.9,87,115.8,32.3,47.1,56.6,97.1,63.9,48.1,62.4,110.3,190.8});
    temp[1]= new RainfallYear(1915, new double []{105.3,129,36.2,37.3,64.3,33.3,123,76.2,39.4,71.4,73.5,182.7});
    temp[2] = new RainfallYear(1916, new double []{58.6,129.4,97.9,47.9,70.7,63.7,51.3,89.2,54.8,142.1,110.1,90.4});
    temp[3]= new RainfallYear(1917, new double []{58.2,30.9,67,55,61.7,65.7,64.3,172.8,54.8,130.7,61.7,43.1
    });
    temp[4] = new RainfallYear(1918, new double []{ 90.1,67.8,39.2,56,57.7,31.5,110.1,60.7,186.2,72.1,67.3,123.2
    });
    temp[5] = new RainfallYear(1919, new double []{117.7,71.4,122.1,62.6,26.6,37,58.3,79.1,53.7,65.4,71.2,143.9
    });
    temp[6] = new RainfallYear(1920, new double []{ 111.3,49.9,91,119,75.2,61.9,133.1,48,69,67.8,45.3,91.4
    });
    temp[7] = new RainfallYear(1921, new double []{110.5,8.7,64.5,32.6,47.8,10.3,31,98.2,38.5,51.7,65.2,80.4
    });
    temp[8] = new RainfallYear(1922,new double []{107.2,95,69.6,77.4,33.2,39.6,119,96.6,80.6,33.1,47.1,118.7
    });
    temp[9] = new RainfallYear(1923, new double []{62.4,153.5,48.3,67.9,67.3,20.5,76.7,95,82.9,137.2,92.5,96.8
    });
     
    Rainfall rainfall = new Rainfall(temp);
    
    // Test that all of the years have been loaded: 1914 to 1923.
    int[] years = rainfall.getYears();
    System.out.println(years.length);
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
    RainfallYear [] temp = new RainfallYear[10];
    temp[0] = new RainfallYear(1914, new double []{ 50.9,87,115.8,32.3,47.1,56.6,97.1,63.9,48.1,62.4,110.3,190.8});
    temp[1]= new RainfallYear(1915, new double []{105.3,129,36.2,37.3,64.3,33.3,123,76.2,39.4,71.4,73.5,182.7});
    temp[2] = new RainfallYear(1916, new double []{58.6,129.4,97.9,47.9,70.7,63.7,51.3,89.2,54.8,142.1,110.1,90.4});
    temp[3]= new RainfallYear(1917, new double []{58.2,30.9,67,55,61.7,65.7,64.3,172.8,54.8,130.7,61.7,43.1
    });
    temp[4] = new RainfallYear(1918, new double []{ 90.1,67.8,39.2,56,57.7,31.5,110.1,60.7,186.2,72.1,67.3,123.2
    });
    temp[5] = new RainfallYear(1919, new double []{117.7,71.4,122.1,62.6,26.6,37,58.3,79.1,53.7,65.4,71.2,143.9
    });
    temp[6] = new RainfallYear(1920, new double []{ 111.3,49.9,91,119,75.2,61.9,133.1,48,69,67.8,45.3,91.4
    });
    temp[7] = new RainfallYear(1921, new double []{110.5,8.7,64.5,32.6,47.8,10.3,31,98.2,38.5,51.7,65.2,80.4
    });
    temp[8] = new RainfallYear(1922,new double []{107.2,95,69.6,77.4,33.2,39.6,119,96.6,80.6,33.1,47.1,118.7
    });
    temp[9] = new RainfallYear(1923, new double []{62.4,153.5,48.3,67.9,67.3,20.5,76.7,95,82.9,137.2,92.5,96.8
    });
     
    Rainfall rainfall = new Rainfall(temp);
    

    // Test that the mean rainfall for a month is correct: for January over all years, the mean is 87.22.
    assertEquals("Incorrect mean rainfall for a month", 87.22, rainfall.calculateMeanRainfallMonth(Month.JANUARY), 0.01);
  }

  /**
   * Test calculation of the mean rainfall over a year.
   */
  @Test
  public void testYear() {
    // Use the rainfall file extracted from Met Office (2008). England & Wales Rainfall (mm).
    // http://www.metoffice.gov.uk/climate/uk/seriesstatistics/ewrain.txt. [Accessed 17-10-2011.]
    RainfallYear [] temp = new RainfallYear[10];
    temp[0] = new RainfallYear(1914, new double []{ 50.9,87,115.8,32.3,47.1,56.6,97.1,63.9,48.1,62.4,110.3,190.8});
    temp[1]= new RainfallYear(1915, new double []{105.3,129,36.2,37.3,64.3,33.3,123,76.2,39.4,71.4,73.5,182.7});
    temp[2] = new RainfallYear(1916, new double []{58.6,129.4,97.9,47.9,70.7,63.7,51.3,89.2,54.8,142.1,110.1,90.4});
    temp[3]= new RainfallYear(1917, new double []{58.2,30.9,67,55,61.7,65.7,64.3,172.8,54.8,130.7,61.7,43.1
    });
    temp[4] = new RainfallYear(1918, new double []{ 90.1,67.8,39.2,56,57.7,31.5,110.1,60.7,186.2,72.1,67.3,123.2
    });
    temp[5] = new RainfallYear(1919, new double []{117.7,71.4,122.1,62.6,26.6,37,58.3,79.1,53.7,65.4,71.2,143.9
    });
    temp[6] = new RainfallYear(1920, new double []{ 111.3,49.9,91,119,75.2,61.9,133.1,48,69,67.8,45.3,91.4
    });
    temp[7] = new RainfallYear(1921, new double []{110.5,8.7,64.5,32.6,47.8,10.3,31,98.2,38.5,51.7,65.2,80.4
    });
    temp[8] = new RainfallYear(1922,new double []{107.2,95,69.6,77.4,33.2,39.6,119,96.6,80.6,33.1,47.1,118.7
    });
    temp[9] = new RainfallYear(1923, new double []{62.4,153.5,48.3,67.9,67.3,20.5,76.7,95,82.9,137.2,92.5,96.8
    });
     
    Rainfall rainfall = new Rainfall(temp);
    

    // Test that the mean rainfall for a year is correct: for 1914 the mean is 80.19.
    assertEquals("Incorrect mean rainfall for a year", 80.19, rainfall.calculateMeanRainfallYear(1914), 0.01);
    
    // Test that the lowest mean annual rainfall is correct: for 1914 the mean is 80.19.
    assertEquals("Incorrect lowest mean annual rainfall", 53.28, rainfall.calculateLowestMeanAnnualRainfall(), 0.01);

    // Test that the highest mean annual rainfall is correct: for 1914 the mean is 80.19.
    assertEquals("Incorrect highest mean annual rainfall", 83.84, rainfall.calculateHighestMeanAnnualRainfall(), 0.01);
  }
}
