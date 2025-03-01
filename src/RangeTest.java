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

	//Tests for UpperBound

	//Declaring and setting up variables
	private Range finiteRangeUpper;
    private Range infiniteRangeUpper;
    private Range nanRangeUpper;

    @Before
    public void setUpUpper() throws Exception {
        // Creating different range scenarios
        finiteRangeUpper = new Range(-10.0, 15.5); // Finite range
        infiniteRangeUpper = new Range(0.0, Double.POSITIVE_INFINITY); // Infinite upper bound
        nanRangeUpper = new Range(5.0, Double.NaN); // NaN upper bound
    }

	//Test for checking upperbound when range has a finite range
    @Test
    public void testGetUpperBoundForFiniteValue() {
        // Upper bound should be 15.5
        assertEquals(15.5, finiteRangeUpper.getUpperBound(), 0.000000001d);
    }

	//test for checking upperbound when range has a positive infinity
    @Test
    public void testGetUpperBoundForInfiniteValue() {
        // Upper bound should be POSITIVE_INFINITY
        assertEquals(Double.POSITIVE_INFINITY, infiniteRangeUpper.getUpperBound(), 0.0);
    }

	//test for checking upperbound when range has a NaN
    @Test
    public void testGetUpperBoundForNaNValue() {
        // Upper bound should be NaN
        assertTrue(Double.isNaN(nanRangeUpper.getUpperBound()));
    }


	//Tests for LowerBound

	//declaring and setting up variables
	private Range finiteRangeLower;
	private Range infiniteRangeLower;
	private Range nanRangeLower;

	@Before
	public void setUpLower() throws Exception {
		// Creating different range scenarios
		finiteRangeLower = new Range(-10.0, 15.5); // Finite range
		infiniteRangeLower = new Range(Double.NEGATIVE_INFINITY, 100.0); // Infinite lower bound
		nanRangeLower = new Range(Double.NaN, 20.0); // NaN lower bound
	}

	//Test for checking lowerbound when range has a finite range
	@Test
	public void testGetLowerBoundForFiniteValue() {
		// Lower bound should be -10.0
		assertEquals(-10.0, finiteRangeLower.getLowerBound(), 0.000000001d);
	}

	//Test for checking lowerbound when range has a negative infinity 
	@Test
	public void testGetLowerBoundForInfiniteValue() {
		// Lower bound should be NEGATIVE_INFINITY
		assertEquals(Double.NEGATIVE_INFINITY, infiniteRangeLower.getLowerBound(), 0.0);
	}

	//Test for checking lowerbound when range has a NaN value
	@Test
	public void testGetLowerBoundForNaNValue() {
		// Lower bound should be NaN
		assertTrue(Double.isNaN(nanRangeLower.getLowerBound()));
	}

}
