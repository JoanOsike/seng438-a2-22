package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

    //Test cases for createNumberArray2D(double[][] data) method
    @Test
    //test for creating an invaild 2Darray of nulls
	public void testCreateNumber2DArrayofNulls() {
		try {
			double[][] array = null;
			
			DataUtilities.createNumberArray2D(array);
			
			fail("Expected is throwing an exception.");
			
		} catch (Exception e) {
			assertEquals("The exception thrown is", IllegalArgumentException.class,
					e.getClass());
		}
	}
    
    @Test
    //test for 2Darrays of positives
	public void testCompareCreateNumber2DArrayofPostivies() {
    	
    	Number[][] expected = { {1.0,2.0}, {3.0,4.0} };
		double[][] array = { {1.0,2.0}, {3.0,4.0} };
		
		assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
	public void testCompareCreateNumber2DArrayofPosandNeg() {
    	
    	Number[][] expected = { {-1.0,2.0}, {-3.0,4.0} };
		double[][] array = { {-1.0,2.0}, {-3.0,4.0} };
		
		assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    //test for 2Darrays of zeros
	public void testCompareCreateNumber2DArrayofZeros() {
    	
		Number[][] expected = { {0,0}, {0,0} };
		double[][] array = { {0,0}, {0,0} };
		
		assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    //test for empty 2Darrays
	public void testCompareCreateNumber2DArrayofEmpty() {

		Number[][] expected = { {}, {} };
		double[][] array = { {}, {} };
		
		assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    //test for 2Darrays of negatives
	public void testCompareCreateNumber2DArrayofNegatives() {

		Number[][] expected = { {-1.0,-2.0}, {-3.0,-4.0} };
		double[][] array = { {-1.0,-2.0}, {-3.0,-4.0} };
		
		assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    //test for 2Darrays of only rows
	public void testCompareCreateNumber2DArrayofOnlyRows() {
        double[][] array = {
                {10.5, 20.5, 30.5}
        };
        Number[][] expected = {
                {10.5, 20.5, 30.5}
        };
        assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    //test for 2Darrays of only cols
	public void testCompareCreateNumber2DArrayofOnlyCols() {
        double[][] array = {
                {1.1},
                {2.2},
                {3.3}
            };
        Number[][] expected = {
                {1.1},
                {2.2},
                {3.3}
        };
        assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    //test for non-rectangle 2Darrays
	public void testCompareCreateNumber2DArraynonRectangle() {
        double[][] array = {
                {1.1, 2.2},
                {3.3, 4.4, 5.5},
                {6.6}
            };
        Number[][] expected = {
            {1.1, 2.2},
            {3.3, 4.4, 5.5},
            {6.6}
        };
        assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }
    
    @Test
    public void testCreateNumber2DArrayofLargeValues() {
        double[][] array = {
            {Double.MAX_VALUE, Double.MIN_VALUE},
            {-Double.MAX_VALUE, -Double.MIN_VALUE}
        };
        Number[][] expected = {
            {Double.MAX_VALUE, Double.MIN_VALUE},
            {-Double.MAX_VALUE, -Double.MIN_VALUE}
        };

        assertArrayEquals("createNumber2DArray() failed. The exception thrown is", expected, DataUtilities.createNumberArray2D(array));
    }

    //Test Cases for CreateNumberArray method

    //test for creating a number array with null data
    @Test
    public void testCreateNumberArrayWithNullData() {
        try {
            DataUtilities.createNumberArray(null);
            fail("Expected an Exception to be thrown.");
        } catch (Exception e) {
            // Test passes if exception is thrown
        }
    }

    //test for creating an empty number array
    @Test
    public void testCreateNumberArrayWithEmptyArray() {
        try {
            Number[] result = DataUtilities.createNumberArray(new double[0]);
            assertNotNull(result);
            assertEquals(0, result.length);
        } catch (Exception e) {
            fail("Exception thrown unexpectedly: " + e.getMessage());
        }
    }

    //test for creating a number array with all positive numbers
    @Test
    public void testCreateNumberArrayWithAllPositiveValues() {
        try {
            double[] input = {1.0, 2.5, 3.3};
            Number[] result = DataUtilities.createNumberArray(input);

            assertNotNull("Result array is null", result);
            assertEquals(3, result.length);
            assertNotNull("Result[2] is null", result[2]);

            assertEquals(1.0, result[0].doubleValue(), 0.000000001d);
            assertEquals(2.5, result[1].doubleValue(), 0.000000001d);
            assertEquals(3.3, result[2].doubleValue(), 0.000000001d);
        } catch (Exception e) {
            fail("Exception thrown unexpectedly: " + e.getMessage());
        }
    }

    //test for creating a number array with all negative numbers
    @Test
    public void testCreateNumberArrayWithAllNegativeValues() {
        try {
            double[] input = {-1.0, -2.5, -3.3};
            Number[] result = DataUtilities.createNumberArray(input);

            assertNotNull("Result array is null", result);
            assertEquals(3, result.length);
            assertNotNull("Result[2] is null", result[2]);

            assertEquals(-1.0, result[0].doubleValue(), 0.000000001d);
            assertEquals(-2.5, result[1].doubleValue(), 0.000000001d);
            assertEquals(-3.3, result[2].doubleValue(), 0.000000001d);
        } catch (Exception e) {
            fail("Exception thrown unexpectedly: " + e.getMessage());
        }
    }

    //test for creating a number array with positive and negative values
    @Test
    public void testCreateNumberArrayWithMixedValues() {
        try {
            double[] input = {-1.5, 0.0, 2.8};
            Number[] result = DataUtilities.createNumberArray(input);

            assertNotNull("Result array is null", result);
            assertEquals(3, result.length);
            assertNotNull("Result[2] is null", result[2]);

            assertEquals(-1.5, result[0].doubleValue(), 0.000000001d);
            assertEquals(0.0, result[1].doubleValue(), 0.000000001d);
            assertEquals(2.8, result[2].doubleValue(), 0.000000001d);
        } catch (Exception e) {
            fail("Exception thrown unexpectedly: " + e.getMessage());
        }
    }

    //test for creating a number array with all zero values
    @Test
    public void testCreateNumberArrayWithZeroValues() {
        try {
            double[] input = {0.0, 0.0, 0.0};
            Number[] result = DataUtilities.createNumberArray(input);

            assertNotNull("Result array is null", result);
            assertEquals(3, result.length);
            assertNotNull("Result[2] is null", result[2]);

            assertEquals(0.0, result[0].doubleValue(), 0.000000001d);
            assertEquals(0.0, result[1].doubleValue(), 0.000000001d);
            assertEquals(0.0, result[2].doubleValue(), 0.000000001d);
        } catch (Exception e) {
            fail("Exception thrown unexpectedly: " + e.getMessage());
        }
    }
}
