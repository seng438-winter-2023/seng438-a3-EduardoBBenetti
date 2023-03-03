package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Stack;

import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @Before
    public void setUp() throws Exception { exampleRange = new Range(-2, 3);
    }

    //--------------------------- getLowerBound()
    @Test
    public void getLowerBoundShouldBeMinusTwo() {
        assertEquals("The lower bound value of -2 and 3 should be -2",
        -2, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundShouldBeOne() {
    	Range R = new Range(1,5);
        assertEquals("The lower bound value of 1 and 5 should be 1",
        1, R.getLowerBound(), .000000001d);
    }
    
    @Test
    public void LowerBiggerThanUpper() {
    	try {
    		Range R = new Range(3, 1);
        	assertTrue("The value is bigger than the lower bound",
        	R.getUpperBound() > R.getLowerBound());
    	} catch(Exception e) {
    		throw e;
    	}
    }
    
    //--------------------------- getUpperBound()
    @Test
    public void getUpperBoundShouldBeThree() {
        assertEquals("The upper bound value of -2 and 3 should be 3",
        3, exampleRange.getUpperBound(), .000000001d);
    }
    
    //--------------------------- getLength()
    @Test
    public void getLengthShouldBeFive() {
        assertEquals("The central value of -2 and 3 should be 5",
        5, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void getLengthShouldBeZero() {
    	Range R = new Range(0,0);
        assertEquals("The central value of 0 and 0 should be 0",
        0, R.getLength(), .000000001d);
    }
    
    //--------------------------- getCentralValue()
    @Test
    public void getCentralValueShouldBeZeroPointFive() {
        assertEquals("The central value of -2 and 3 should be 0.5",
        0.5, exampleRange.getCentralValue(), .000000001d);
    }
    
    //--------------------------- contains(double value)
    @Test
    public void containsShouldBeFalseLower() {
        assertFalse("The answer should be false",
        exampleRange.contains(-5));
    }
    
    @Test
    public void containsShouldBeFalseUpper() {
        assertFalse("The answer should be false",
        exampleRange.contains(6.3));
    }
    
    @Test
    public void containsShouldBeTrueLowerBound() {
        assertTrue("The answer should be true",
        exampleRange.contains(-2));
    }
    
    @Test
    public void containsShouldBeTrueUpperBound() {
        assertTrue("The answer should be true",
        exampleRange.contains(3));
    }
    
    @Test
    public void containsShouldBeTrueBetween() {
        assertTrue("The answer should be true",
        exampleRange.contains(0));
    }
    
    @Test
    public void containsCorrect() {
        assertTrue("The answer should be true",
        exampleRange.contains(1));
    }
  
    //--------------------------- intersects(double b0, double b1)
    @Test
    public void intersectsShouldBeTrueLower() {
        assertTrue("The lines interesect",
        exampleRange.intersects(-3, 0));
    }
    
    @Test
    public void intersectsShouldBeTrueMiddle() {
        assertTrue("The lines interesect",
        exampleRange.intersects(1, 2));
    }
    
    @Test
    public void intersectsShouldBeTrueUpper() { // This test case is not working
        assertTrue("The lines interesect",
        exampleRange.intersects(2, 6));
    }
    
    @Test
    public void intersectsShouldBeTrueLowerUpper() {
        assertTrue("The lines interesect",
        exampleRange.intersects(-4, 4));
    }
    
    @Test
    public void intersectsShouldBeFalseLower() { // This test case is not working
        assertFalse("The lines do not interesect",
        exampleRange.intersects(-7, -4));
    }
    
    @Test
    public void intersectsShouldBeFalseUpper() {
        assertFalse("The lines do not interesect",
        exampleRange.intersects(4, 6));
    }
    
    //--------------------------- intersects(Range range)
    @Test
    public void intersectsBoolean() {
    	Range R = new Range(0,1);
        assertTrue("The lines interesect",
        exampleRange.intersects(R));
    }
    
    @Test
    public void intersectsBoolean2() {
    	Range R = new Range(0,1);
        assertTrue("The lines interesect",
        exampleRange.intersects(R));
    }

    //--------------------------- constrain()
    @Test
    public void constrainBetween() {
    	assertEquals("The answer should be 2",
    	2 , exampleRange.constrain(2), .000000001d);
    }
    
    @Test
    public void constrainUpperBound() {
    	assertEquals("The answer should be 3",
    	3 , exampleRange.constrain(4), .000000001d);
    }

    @Test
    public void constrainLowerBound() {
    	assertEquals("The answer should be -2",
    	-2 , exampleRange.constrain(-3), .000000001d);
    }
    
    //--------------------------- combine(Range range1, Range range2)
    @Test
    public void combineRange1Null() {
    	assertEquals("The range is -3 to 2",
    	exampleRange, Range.combine(null, exampleRange));
    }
    
    @Test
    public void combineRange2Null() {
    	assertEquals("The range is -3 to 2",
    	exampleRange, Range.combine(exampleRange, null));
    }
    
    @Test
    public void combineRight() {
    	Range R = new Range(1, 3);
    	Range C = new Range(-2, 3);
    	assertEquals("The range is -3 to 3",
    	C, Range.combine(exampleRange, R));
    }
    
    //--------------------------- combineIgnoringNaN(Range range1, Range range2)
    @Test
    public void combineIgnoringNaNNullNull() {
        assertEquals("The returned value is null",
        null, Range.combineIgnoringNaN(null, null));
    }
    
    @Test
    public void combineIgnoringNaNNullNotNull() {
    	Range R = new Range(Double.NaN,Double.NaN);
        assertEquals("The returned value is a range of NaN",
        null, Range.combineIgnoringNaN(null, R));
    }
    
    @Test
    public void combineIgnoringNaNNotNullNull() {
    	Range R = new Range(Double.NaN,Double.NaN);
        assertEquals("The returned value is a range of NaN",
        null, Range.combineIgnoringNaN(R, null));
    }
    
    @Test
    public void combineIgnoringNaNNumberNull() {
        assertEquals("The returned value is a range of -3 to 2",
        exampleRange, Range.combineIgnoringNaN(exampleRange, null));
    }
    
    @Test
    public void combineIgnoringNaNNumberNumber() {
    	Range R = new Range(1,4);
    	Range C = new Range(-2,4);
        assertEquals("The returned value is a range of -2 to 4",
        C, Range.combineIgnoringNaN(exampleRange, R));
    }
    
    @Test
    public void combineIgnoringNaNNaNNaN() {
    	Range R = new Range(Double.NaN,Double.NaN);
    	Range S = new Range(Double.NaN,Double.NaN);
        assertEquals("The returned value is a range of NaN",
        null, Range.combineIgnoringNaN(R, S));
    }
    
    //--------------------------- expandToInclude(Range range, double value)
    @Test
    public void expandToIncludeValueLessThanLower() {
    	Range R = new Range(-4,3);
        assertEquals("The range should be -4 to 3",
        R, Range.expandToInclude(exampleRange, -4));
    }
    
    @Test
    public void expandToIncludeValueMoreThanUpper() {
    	Range R = new Range(-2,4);
        assertEquals("The range should be -2 to 4",
        R, Range.expandToInclude(exampleRange, 4));
    }
    
    @Test
    public void expandToIncludeEqual() {
        assertEquals("The range should be -3 to 2",
        exampleRange, Range.expandToInclude(exampleRange, 2));
    }
    
    @Test
    public void expandToIncludeRangeNull() {
    	Range R = new Range(2,2);
        assertEquals("The range should be 2 to 2",
        R, Range.expandToInclude(null, 2));
    }
    
    //--------------------------- expand(Range range, double lowerMargin, double upperMargin)
    @Test
    public void expandRange() {
    	Range R = new Range(18,23);
        assertEquals("The range should be 18 to 23",
        R, Range.expand(exampleRange, -4, 4));
    }
    
    //--------------------------- shift(Range base, double delta)    
    @Test
    public void shiftTwoArgs() {
    	Range R = new Range(0, 5);
    	assertEquals("The range should be -1 to 5",
    	R, Range.shift(exampleRange, 2));
    }
    
    //--------------------------- shift(Range base, double delta, boolean allowZeroCrossing)
    @Test
    public void shiftTrue() {
    	Range R = new Range(0, 5);
    	assertEquals("The range should be 0 to 5",
    	R, Range.shift(exampleRange, 2, true));
    }
    
    @Test
    public void shiftFalse() {
    	Range R = new Range(0, 5);
    	assertEquals("The range should be 0 to 5",
    	R, Range.shift(exampleRange, 2, false));
    }
    
    //--------------------------- scale(Range base, double factor)
    @Test
    public void scalePositive() {
    	Range R = new Range(-4,6);
    	assertEquals("The range should be -4 to 6",
    	R, Range.scale(exampleRange, 2));
    }
    
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
    @Test
    public void equalsIsLower() {
    	Range R = new Range(1,2);
    	assertFalse("The lower bound of R is not equal to exampleRange lower bound",
    	exampleRange.equals(R));
    }
    
    @Test
    public void equalsIsNotRange() {
    	assertFalse("The Object is not a Range",
    	exampleRange.equals("Fluminense"));
    }
    
    @Test
    public void equalsIsUpper() {
    	Range R = new Range(-2,6);
    	assertFalse("The upper bound of R is not equal to exampleRange upper bound",
    	exampleRange.equals(R));
    }
    
    @Test
    public void equalsTrue() {
    	Range R = new Range(-2,3);
    	assertTrue("Both Ranges of exampleRange and R are equal",
    	exampleRange.equals(R));
    }
    
    //--------------------------- isNaNRange()
    @Test
    public void isNaNRangeTrue() {
    	assertFalse("The range is NaN",
    	exampleRange.isNaNRange());
    }
    
    //--------------------------- hashCode()
    @Test
    public void hashCodeTest() {
        assertEquals("The hash code is 524288",
        524288 , exampleRange.hashCode());
    }
    
    //--------------------------- toString()
    @Test
    public void toStringNegativePositive() {
        assertEquals("The answer should be 'Range[-2.0,3.0]'",
        "Range[-2.0,3.0]" , exampleRange.toString());
    }
    
    @Test
    public void toStringPositivePositive() {
    	Range R = new Range(2, 4.2);
        assertEquals("The answer should be 'Range[2.0,4.2]'",
        "Range[2.0,4.2]" , R.toString());
    }
    
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