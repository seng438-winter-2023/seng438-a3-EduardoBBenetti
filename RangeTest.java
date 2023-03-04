package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Stack;

import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @Before
    public void setUp() throws Exception { exampleRange = new Range(-2, 3);
    }

    //--------------------------- constructor
    /**
     * This method is testing the constructor when 
     * the lower bound is bigger than the upper bound
     */
    @Test
    public void LowerBiggerThanUpper() {
    	try {
    		Range R = new Range(3, 1);
    	} catch(Exception e) {
    		throw e;
    	}
    }
    
    //--------------------------- getLowerBound()
    /**
     * This method is testing the getter method of lower bound
     */
    @Test
    public void getLowerBoundShouldBeMinusTwo() {
        assertEquals("The lower bound value of -2 and 3 should be -2",
        -2, exampleRange.getLowerBound(), .000000001d);
    }
    
    /**
     * This method is testing the getter method 
     * of lower bound with a new Range instance
     */
    @Test
    public void getLowerBoundShouldBeOne() {
    	Range R = new Range(1,5);
        assertEquals("The lower bound value of 1 and 5 should be 1",
        1, R.getLowerBound(), .000000001d);
    }
    
    //--------------------------- getUpperBound()
    /**
     * This method is testing the getter method
     * of the upper bound
     */
    @Test
    public void getUpperBoundShouldBeThree() {
        assertEquals("The upper bound value of -2 and 3 should be 3",
        3, exampleRange.getUpperBound(), .000000001d);
    }
    
    //--------------------------- getLength()
    /**
     * This method is testing the getLength() function of the
     * length between the lower and upper bounds
     */
    @Test
    public void getLengthShouldBeFive() {
        assertEquals("The central value of -2 and 3 should be 5",
        5, exampleRange.getLength(), .000000001d);
    }
    
    /**
     * This method is testing the getLength() function with
     * both the lower and upper bounds being the same
     */
    @Test
    public void getLengthShouldBeZero() {
    	Range R = new Range(0,0);
        assertEquals("The central value of 0 and 0 should be 0",
        0, R.getLength(), .000000001d);
    }
    
    //--------------------------- getCentralValue()
    /**
     * This method is testing the getCentralValue() which
     * gets the central value between the lower and upper
     * bounds of a range
     */
    @Test
    public void getCentralValueShouldBeZeroPointFive() {
        assertEquals("The central value of -2 and 3 should be 0.5",
        0.5, exampleRange.getCentralValue(), .000000001d);
    }
    
    //--------------------------- contains(double value)
    /**
     * This method is testing contains() for a value lower
     * than the lower bound
     */
    @Test
    public void containsShouldBeFalseLower() {
        assertFalse("The answer should be false",
        exampleRange.contains(-5));
    }
    
    /**
     * This method is testing contains() for a value bigger
     * than the upper bound
     */
    @Test
    public void containsShouldBeFalseUpper() {
        assertFalse("The answer should be false",
        exampleRange.contains(6.3));
    }
    
    /**
     * This method is testing contains() for a value close
     * to the lower bound, but bigger than it
     */
    @Test
    public void containsShouldBeTrueLowerBound() {
        assertTrue("The answer should be true",
        exampleRange.contains(-2));
    }
    
    /**
     * This method is testing contains() for a value close
     * to the upper bound, but smaller than it
     */
    @Test
    public void containsShouldBeTrueUpperBound() {
        assertTrue("The answer should be true",
        exampleRange.contains(3));
    }
    
    /**
     * This method is testing contains() for a value that is
     * bigger than the lower bound and smaller than the
     *  upper bound
     */
    @Test
    public void containsShouldBeTrueBetween() {
        assertTrue("The answer should be true",
        exampleRange.contains(0));
    }
    
    /**
     * This method is testing contains() for a value that is
     * bigger than the lower bound and smaller than the
     *  upper bound
     */
    @Test
    public void containsCorrect() {
        assertTrue("The answer should be true",
        exampleRange.contains(1));
    }
  
    //--------------------------- intersects(double b0, double b1)
    /**
     * This method is testing if the two points intersects
     * with the exampleRange range in the lower bound
     */
    @Test
    public void intersectsShouldBeTrueLower() {
        assertTrue("The lines interesect",
        exampleRange.intersects(-3, 0));
    }
    
    /**
     * This method is testing if the two points intersects
     * with the exampleRange range in between the range
     */
    @Test
    public void intersectsShouldBeTrueMiddle() {
        assertTrue("The lines interesect",
        exampleRange.intersects(1, 2));
    }
    
    /**
     * This method is testing if the two points intersects
     * with the exampleRange range in the upper bound
     */
    @Test
    public void intersectsShouldBeTrueUpper() { // This test case is not working
        assertTrue("The lines interesect",
        exampleRange.intersects(2, 6));
    }
    
    /**
     * This method is testing if the two points intersects
     * with the exampleRange range, where the two points are
     * overlaps the exampleRange
     */
    @Test
    public void intersectsShouldBeTrueLowerUpper() {
        assertTrue("The lines interesect",
        exampleRange.intersects(-4, 4));
    }
    
    /**
     * This method is testing if the two points intersects
     * with the exampleRange range in the lower bound where
     * the points are smaller than the lower bound
     */
    @Test
    public void intersectsShouldBeFalseLower() { // This test case is not working
        assertFalse("The lines do not interesect",
        exampleRange.intersects(-7, -4));
    }
    
    /**
     * This method is testing if the two points intersects
     * with the exampleRange range in the upper bound where
     * the points are bigger than the upper bound
     */
    @Test
    public void intersectsShouldBeFalseUpper() {
        assertFalse("The lines do not interesect",
        exampleRange.intersects(4, 6));
    }
    
    //--------------------------- intersects(Range range)
    /**
     * This method is testing if the given Range intersects
     * with the exampleRange range, range argument is
     * in between the exampleRange
     */
    @Test
    public void intersectsBoolean() {
    	Range R = new Range(0,1);
        assertTrue("The lines interesect",
        exampleRange.intersects(R));
    }

    //--------------------------- constrain()
    /**
     * This method is testing whether the function will return
     * the closest range bound to the input number, 
     * for this one the upper bound
     */
    @Test
    public void constrainBetween() {
    	assertEquals("The answer should be 2",
    	2 , exampleRange.constrain(2), .000000001d);
    }
    
    /**
     * This method is testing whether the function will return
     * the closest range bound to the input number, 
     * for this one the upper bound
     */
    @Test
    public void constrainUpperBound() {
    	assertEquals("The answer should be 3",
    	3 , exampleRange.constrain(4), .000000001d);
    }

    /**
     * This method is testing whether the function will return
     * the closest range bound to the input number, 
     * for this one the lower bound
     */
    @Test
    public void constrainLowerBound() {
    	assertEquals("The answer should be -2",
    	-2 , exampleRange.constrain(-3), .000000001d);
    }
    
    //--------------------------- combine(Range range1, Range range2)
    /**
     * This method is testing the combination of a null range with
     * a rational range which should return the rational range
     */
    @Test
    public void combineRange1Null() {
    	assertEquals("The range is -3 to 2",
    	exampleRange, Range.combine(null, exampleRange));
    }
    
    /**
     * This method is testing the combination of a rational range with
     * a null range which should return the rational range
     */
    @Test
    public void combineRange2Null() {
    	assertEquals("The range is -3 to 2",
    	exampleRange, Range.combine(exampleRange, null));
    }
    
    /**
     * This method is testing the combination of two ranges which should
     * be -3 to 3
     */
    @Test
    public void combineRight() {
    	Range R = new Range(1, 3);
    	Range C = new Range(-2, 3);
    	assertEquals("The range is -3 to 3",
    	C, Range.combine(exampleRange, R));
    }
    
    //--------------------------- combineIgnoringNaN(Range range1, Range range2)
    /**
     * This method is testing to combination of two ranges when they are 
     * both null, which should return null
     */
    @Test
    public void combineIgnoringNaNNullNull() {
        assertEquals("The returned value is null",
        null, Range.combineIgnoringNaN(null, null));
    }
    
    /**
     * This method is testing to combination of two ranges when they are 
     * null and NaN, which should return null
     */
    @Test
    public void combineIgnoringNaNNullNotNull() {
    	Range R = new Range(Double.NaN,Double.NaN);
        assertEquals("The returned value is a range of NaN",
        null, Range.combineIgnoringNaN(null, R));
    }
    
    /**
     * This method is testing to combination of two ranges when they are 
     * NaN and null, which should return null
     */
    @Test
    public void combineIgnoringNaNNotNullNull() {
    	Range R = new Range(Double.NaN,Double.NaN);
        assertEquals("The returned value is a range of NaN",
        null, Range.combineIgnoringNaN(R, null));
    }
    
    /**
     * This method is testing to combination of two ranges when they are 
     * valid range and null, which should return the valid range
     */
    @Test
    public void combineIgnoringNaNNumberNull() {
        assertEquals("The returned value is a range of -3 to 2",
        exampleRange, Range.combineIgnoringNaN(exampleRange, null));
    }
    
    /**
     * This method is testing to combination of two ranges when they are 
     * both valid ranges, which should return the largest possible range
     * between both of the ranges given
     */
    @Test
    public void combineIgnoringNaNNumberNumber() {
    	Range R = new Range(1,4);
    	Range C = new Range(-2,4);
        assertEquals("The returned value is a range of -2 to 4",
        C, Range.combineIgnoringNaN(exampleRange, R));
    }
    
    /**
     * This method is testing to combination of two ranges when they are 
     * both NaN, which should return null
     */
    @Test
    public void combineIgnoringNaNNaNNaN() {
    	Range R = new Range(Double.NaN,Double.NaN);
    	Range S = new Range(Double.NaN,Double.NaN);
        assertEquals("The returned value is a range of NaN",
        null, Range.combineIgnoringNaN(R, S));
    }
    
    //--------------------------- expandToInclude(Range range, double value)
    /**
     * This method is testing the expansion of a range to include a
     * given value, for this test, the range should return with the
     * lower bound extended to include the given value
     */
    @Test
    public void expandToIncludeValueLessThanLower() {
    	Range R = new Range(-4,3);
        assertEquals("The range should be -4 to 3",
        R, Range.expandToInclude(exampleRange, -4));
    }
    
    /**
     * This method is testing the expansion of a range to include a
     * given value, for this test, the range should return with the
     * upper bound extended to include the given value
     */
    @Test
    public void expandToIncludeValueMoreThanUpper() {
    	Range R = new Range(-2,4);
        assertEquals("The range should be -2 to 4",
        R, Range.expandToInclude(exampleRange, 4));
    }
    
    /**
     * This method is testing the expansion of a range to include a
     * given value, for this test, the range should return the
     * same range since the value is in between the range
     */
    @Test
    public void expandToIncludeEqual() {
        assertEquals("The range should be -3 to 2",
        exampleRange, Range.expandToInclude(exampleRange, 2));
    }
    
    /**
     * This method is testing the expansion of a range to include a
     * given value, for this test, the range should return with the
     * lower and upper bounds equal to the given value since the
     * given range is null
     */
    @Test
    public void expandToIncludeRangeNull() {
    	Range R = new Range(2,2);
        assertEquals("The range should be 2 to 2",
        R, Range.expandToInclude(null, 2));
    }
    
    //--------------------------- expand(Range range, double lowerMargin, double upperMargin)
    /**
     * This method is testing the expansion of the range with two margins,
     * lower and upper, which are supposed to multiple the lower and upper
     * bounds and add or subtract depending on the bound wanted to get the
     * new lower and upper bounds
     */
    @Test
    public void expandRange() {
    	Range R = new Range(18,23);
        assertEquals("The range should be 18 to 23",
        R, Range.expand(exampleRange, -4, 4));
    }
    
    //--------------------------- shift(Range base, double delta)
    /**
     * This method is testing the shifting of the range which in this test
     * it will shift 2 to the right of the given range
     */
    @Test
    public void shiftTwoArgs() {
    	Range R = new Range(0, 5);
    	assertEquals("The range should be 0 to 5",
    	R, Range.shift(exampleRange, 2));
    }
    
    //--------------------------- shift(Range base, double delta, boolean allowZeroCrossing)
    /**
     * This method is testing the shifting of the range which in this test
     * it will shift 2 to the right of the given range
     */
    @Test
    public void shiftTrue() {
    	Range R = new Range(0, 5);
    	assertEquals("The range should be 0 to 5",
    	R, Range.shift(exampleRange, 2, true));
    }
    
    /**
     * This method is testing the shifting of the range which in this test
     * it will shift 2 to the right of the given range
     */
    @Test
    public void shiftFalse() {
    	Range R = new Range(0, 5);
    	assertEquals("The range should be 0 to 5",
    	R, Range.shift(exampleRange, 2, false));
    }
    
    //--------------------------- scale(Range base, double factor)
    /**
     * This method is testing the scaling of the range, which given the
     * factor value, the range of the lower and upper bounds should multiply
     * by that value to get the new lower and upper bounds
     */
    @Test
    public void scalePositive() {
    	Range R = new Range(-4,6);
    	assertEquals("The range should be -4 to 6",
    	R, Range.scale(exampleRange, 2));
    }
    
    /**
     * This method is testing the scaling of the range, but with a negative
     * factor which should throw an error
     */
    @Test
    public void scaleNegative() {
    	try {
    		assertEquals("The factor is negative",
    		null, Range.scale(exampleRange, -2));
    	} catch(Exception e) {
    		throw e;
    	}
    }
    
    //--------------------------- equals(Object obj)
    /**
     * This method is testing if the lower bound of the given Object is
     * equal to the lower bound of the exampleRange
     */
    @Test
    public void equalsIsLower() {
    	Range R = new Range(1,2);
    	assertFalse("The lower bound of R is not equal to exampleRange lower bound",
    	exampleRange.equals(R));
    }
    
    /**
     * This method is testing if the Object argument is a Range object or
     * not
     */
    @Test
    public void equalsIsNotRange() {
    	assertFalse("The Object is not a Range",
    	exampleRange.equals("Fluminense"));
    }
    
    /**
     * This method is testing if the upper bound of the given Object is
     * equal to the lower bound of the exampleRange
     */
    @Test
    public void equalsIsUpper() {
    	Range R = new Range(-2,6);
    	assertFalse("The upper bound of R is not equal to exampleRange upper bound",
    	exampleRange.equals(R));
    }
    
    /**
     * This method is testing if the lower and upper bound of the Object
     * is equal to the lower and upper bound of exampleRange which should
     * be true
     */
    @Test
    public void equalsTrue() {
    	Range R = new Range(-2,3);
    	assertTrue("Both Ranges of exampleRange and R are equal",
    	exampleRange.equals(R));
    }
    
    //--------------------------- isNaNRange()
    /**
     * This method is testing if the lower and upper bounds are
     * a Double.NaN object
     */
    @Test
    public void isNaNRangeTrue() {
    	assertFalse("The range is NaN",
    	exampleRange.isNaNRange());
    }
    
    //--------------------------- hashCode()
    /**
     * This method is testing if the hash code generated is equal to the
     * calculated hash code for the lower and upper bounds
     */
    @Test
    public void hashCodeTest() {
        assertEquals("The hash code is 524288",
        524288 , exampleRange.hashCode());
    }
    
    //--------------------------- toString()
    /**
     * This method is testing the conversion of a negative lower bound
     * and positive upper bound to string
     */
    @Test
    public void toStringNegativePositive() {
        assertEquals("The answer should be 'Range[-2.0,3.0]'",
        "Range[-2.0,3.0]" , exampleRange.toString());
    }
    
    /**
     * This method is testing the conversion of a positive lower bound
     * and positive upper bound to string
     */
    @Test
    public void toStringPositivePositive() {
    	Range R = new Range(2, 4.2);
        assertEquals("The answer should be 'Range[2.0,4.2]'",
        "Range[2.0,4.2]" , R.toString());
    }
    
    /**
     * This method is testing the conversion of a negative lower bound
     * and negative upper bound to string
     */
    @Test
    public void toStringNegativeNegative() {
    	Range R = new Range(-4.3, -1.2);
        assertEquals("The answer should be 'Range[-4.3,-1.2]'",
        "Range[-4.3,-1.2]" , R.toString());
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
}