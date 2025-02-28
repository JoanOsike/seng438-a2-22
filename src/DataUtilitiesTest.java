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
}
