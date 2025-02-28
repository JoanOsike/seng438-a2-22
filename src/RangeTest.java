package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }
    

  //Test cases for ToString()
  	 
  	    @Test
  	    public void testToStringWithPositiveNumbers() {
  	        Range range = new Range(5.0, 10.0);
  	        String expected = "Range[5.0,10.0]";
  	        assertEquals("toString should return Range[lower,upper]", expected, range.toString());
  	    }
  	    
  	    @Test
  	    public void testToStringWithNegativeNumbers() {
  	        Range range = new Range(-2.0, -1.0);
  	        String expected = "Range[-2.0,-1.0]";
  	        assertEquals("toString should correctly format negative values", expected, range.toString());
  	    }
  	    
  	    @Test
  	    public void testToStringWithSameNumbers() {
  	        Range range = new Range(1.0, 1.0);
  	        String expected = "Range[1.0,1.0]";
  	        assertEquals("toString should correctly format negative values", expected, range.toString());
  	    }
  	    
  	    @Test
  	    public void testToStringWithZero() {
  	        Range range = new Range(0.0, 0.0);
  	        String expected = "Range[0.0,0.0]";
  	        assertEquals("toString should handle zero values", expected, range.toString());
  	    }
  	    
  	    @Test
  	    public void testToStringWithMixedValues() {
  	        Range range = new Range(-1.0, 1.0);
  	        String expected = "Range[-1.0,1.0]";
  	        assertEquals("toString should correctly display mixed values", expected, range.toString());
  	    }
    
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
