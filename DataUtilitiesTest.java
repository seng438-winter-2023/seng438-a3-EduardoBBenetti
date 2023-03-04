package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;

import org.jfree.data.KeyedValues;

import org.jfree.data.Values2D;

import org.jmock.*;

import org.junit.Test;

public class DataUtilitiesTest {
	
	//**************************************************************
	// Previous Tests Done for Assignment 2
	//**************************************************************

	/*
	 * method to test calculateColumnTotal(Values2D data, int column)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * 
	 * result should be 5
	 */
	@Test
	public void calculateColumnTotalForFourValues() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(4));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(1, 0);

				will(returnValue(2.5));

				one(values).getValue(2, 0);

				will(returnValue(-3));

				one(values).getValue(3, 0);

				will(returnValue(-2));

			}

		});

		double result = DataUtilities.calculateColumnTotal(values, 0);

		assertEquals(5.0, result, .000000001d);

	}

	
	/*
	 * method to test calculateColumnTotal(Values2D data, int column)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * and a negative value for column is given
	 * 
	 * result: method should return 0
	 */
	@Test
	public void calculateColumnTotalWithInvalidInput() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(4));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(1, 0);

				will(returnValue(2.5));

				one(values).getValue(2, 0);

				will(returnValue(-3));

				one(values).getValue(3, 0);

				will(returnValue(-2));

			}

		});

		double result = DataUtilities.calculateColumnTotal(values, -1);

		assertEquals(0.0, result, .000000001d);

	}

	/*
	 * method to test calculateColumnTotal(Values2D data, int column)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with null values
	 * 
	 * result should throw an exception
	 */
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalWithInvalidParameter() throws InvalidParameterException {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(null));

				one(values).getColumnCount();

				will(returnValue(null));

			}

		});

		double result = DataUtilities.calculateColumnTotal(values, 0);

		assertEquals(0, result, .000000001d);

	}
	
	/*
	 * method to test calculateRowTotal(Values2D data, int row)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with null values
	 * 
	 * result should throw an exception
	 */
	@Test(expected = InvalidParameterException.class)
	public void calculateRowTotalWithInvalidParameter() throws InvalidParameterException {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(null));

				one(values).getColumnCount();

				will(returnValue(null));

			}

		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(0, result, .000000001d);

	}

	/*
	 * method to test calculateRowTotal(Values2D data, int row)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * and a negative value for rows is given
	 * 
	 * result method should return 0
	 */
	@Test
	public void calculateRowTotalWithInvalidInput() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getColumnCount();

				will(returnValue(4));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(0, 1);

				will(returnValue(2.5));

				one(values).getValue(0, 2);

				will(returnValue(-3));

				one(values).getValue(0, 3);

				will(returnValue(-2));

			}

		});

		double result = DataUtilities.calculateRowTotal(values, -1);

		assertEquals(0.0, result, .000000001d);

	}

	/*
	 * method to test calculateRowTotal(Values2D data, int row)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * and a positive value given for row
	 * 
	 * result method should return 5
	 */
	@Test
	public void calculateRowTotalForFourValues() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getColumnCount();

				will(returnValue(4));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(0, 1);

				will(returnValue(2.5));

				one(values).getValue(0, 2);

				will(returnValue(-3));

				one(values).getValue(0, 3);

				will(returnValue(-2));

			}

		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(5.0, result, .000000001d);

	}

	/*
	 * method to test createNumberArray(double[] array)
	 * in DataUtilities Class
	 * 
	 * a valid double[] is given to the function
	 * 
	 * result should be Number[] equivalent to the double[]
	 */
	@Test
	public void testCreateNumberArray() {

		double[] input = { 1, 2, 3, 4, 5 };

		Number[] expectedOutput = { 1.0, 2.0, 3.0, 4.0, 5.0 };

		Number[] actualOutput = DataUtilities.createNumberArray(input);

		assertArrayEquals(expectedOutput, actualOutput);

	}

	/*
	 * method to test createNumberArray(double[] array)
	 * in DataUtilities Class
	 * a null double[] is passed to the method
	 * 
	 * result should throw an exception
	 */
	@Test(expected = InvalidParameterException.class)
	public void testCreateNumberArrayWithInvalidData() throws InvalidParameterException {

		double[] input = null;

		DataUtilities.createNumberArray(input);

	}

	/*
	 * method to test createNumberArray2D(double[][] array)
	 * in DataUtilities Class
	 * 
	 * a valid double[][] is given to the function
	 * 
	 * result should be Number[][] equivalent to the double[][]
	 */
	@Test
	public void testCreateNumberArray2D() {

		double[][] input = { { 1, 2 }, { 3, 4 }, { 5, 9 } };

		Number[][] expectedOutput = { { 1.0, 2.0 }, { 3.0, 4.0 }, { 5.0, 9.0 } };

		Number[][] actualOutput = DataUtilities.createNumberArray2D(input);

		assertArrayEquals(expectedOutput, actualOutput);

	}
	
	/*
	 * method to test createNumberArray2D(double[][] array)
	 * in DataUtilities Class
	 * 
	 * a null double[][] is given to the method 
	 * 
	 * result should throw an exception
	 */
	@Test(expected = InvalidParameterException.class)
	public void testCreateNumberArray2DWithInvalidData() throws InvalidParameterException {

		double[][] input = null;

		DataUtilities.createNumberArray2D(input);

	}

	
	/*
	 * method to test getCumulativePercentage(keyedValues values)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock keyedValues objects
	 * a valid keyedValues mock is done with valid values
	 * 
	 * result method should return a keyedValues object containing the correct cumulative percentages
	 */
	@Test
	public void testGetCumulativePercentage() {

		Mockery mockingContext = new Mockery();

		final KeyedValues values = mockingContext.mock(KeyedValues.class);

		mockingContext.checking(new Expectations() {

			{

				allowing(values).getItemCount();

				will(returnValue(3));

				allowing(values).getKeys();

				will(returnIterator(0, 1, 2));

				allowing(values).getValue(0);

				will(returnValue(5));

				allowing(values).getValue(1);

				will(returnValue(9));

				allowing(values).getValue(2);

				will(returnValue(2));

				allowing(values).getKey(0);

				will(returnValue(0));

				allowing(values).getKey(1);

				will(returnValue(1));

				allowing(values).getKey(2);

				will(returnValue(2));

			}

		});

		Mockery mocking = new Mockery();

		final KeyedValues expectedOutput = mocking.mock(KeyedValues.class);

		mocking.checking(new Expectations() {

			{

				one(expectedOutput).getItemCount();

				will(returnValue(3));

				one(expectedOutput).getKeys();

				will(returnIterator(0, 1, 2));

				one(expectedOutput).getValue(0);

				will(returnValue(0.3125));

				one(expectedOutput).getValue(1);

				will(returnValue(0.875));

				one(expectedOutput).getValue(2);

				will(returnValue(1.0));

			}

		});

		KeyedValues actualOutput = DataUtilities.getCumulativePercentages(values);

		assertEquals(expectedOutput.getValue(0), actualOutput.getValue(0));

		assertEquals(expectedOutput.getValue(1), actualOutput.getValue(1));

		assertEquals(expectedOutput.getValue(2), actualOutput.getValue(2));

	}
	
	//**************************************************************
	// New Tests Done for Assignment 3
	//**************************************************************
	
	/*
	 * method to test equal(double[][] a, double[][] b)
	 * in DataUtilities Class
	 * 
	 * 2 equal valid double[][] are given to the function
	 * 
	 * result method should return a boolean true
	 */
	@Test
	public void testEqualWithEqualArrays() {
		
		double[][] first = {{1,2}, {3,4}, {-9, 10}};
		double[][] second = {{1,2}, {3,4}, {-9, 10}};
		
		boolean expected = true;
		
		boolean actual = DataUtilities.equal(first, second);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * method to test equal(double[][] a, double[][] b)
	 * in DataUtilities Class
	 * 
	 * 2 null double[][] are given to the function
	 * 
	 * result method should return a boolean true 
	 */
	@Test
	public void testEqualWithNullArrays() {
		
		double[][] first = null;
		double[][] second = null;
		
		boolean expected = true;
		
		boolean actual = DataUtilities.equal(first, second);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * method to test equal(double[][] a, double[][] b)
	 * in DataUtilities Class
	 * 
	 * 1 null double[][] and 1 valid double[][] are given to the function
	 * 
	 * result method should return a boolean false 
	 */
	@Test
	public void testEqualWithOneNullAndNonNull() {
		
		double[][] first = {{1,2}, {3,4}, {-9, 10}};
		double[][] second = null;
		
		boolean expected = false;
		
		boolean actual = DataUtilities.equal(first, second);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * method to test equal(double[][] a, double[][] b)
	 * in DataUtilities Class
	 * 
	 * 2 equal valid double[][] with different lengths are given to the function
	 * 
	 * result method should return a boolean false 
	 */
	@Test
	public void testEqualWithDifferentLengthArrays() {
		
		double[][] first = {{1,2}, {3,4}, {-9, 10}};
		double[][] second = {{2,4}};
		
		boolean expected = false;
		
		boolean actual = DataUtilities.equal(first, second);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * method to test equal(double[][] a, double[][] b)
	 * in DataUtilities Class
	 * 
	 * 2 equal valid double[][] with different arrays are given to the function
	 * 
	 * result method should return a boolean false 
	 */
	@Test
	public void testEqualWithSameLengthDifferentArrays() {
		
		double[][] first = {{1,2}, {3,4}, {-9, 10}};
		double[][] second = {{1,2}, {3,5}, {-9, 10}};
		
		boolean expected = false;
		
		boolean actual = DataUtilities.equal(first, second);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * method to test clone(double[][] source)
	 * in DataUtilities Class
	 * 
	 * a valid double[][] is given to the function
	 * 
	 * result method should return a clone of the double[][]
	 */
	@Test
	public void testCloneWithValidArray() {
		
		double[][] expected = {{1,2}, {3,4}, {-9, 10}};
		
		double[][] actual = DataUtilities.clone(expected);
		
		assertArrayEquals(expected, actual);
	}
	
	/*
	 * method to test calculateColumnTotal(Values2D data, int column,
             int[] validRows)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values, and a valid int[] column
	 * 
	 * result should be 14
	 */
	@Test
	public void testCalculateColumnTotalWithValidRowsSpecified() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(1, 0);

				will(returnValue(2.5));

				one(values).getValue(2, 0);

				will(returnValue(-3));

				one(values).getValue(3, 0);

				will(returnValue(-2));
				
				one(values).getValue(4, 0);

				will(returnValue(7));
				
				one(values).getValue(5, 0);

				will(returnValue(-3.5));

			}

		});

		int[] validrows = {0,1,2,4};
		
		double result = DataUtilities.calculateColumnTotal(values, 0, validrows);

		assertEquals(14.0, result, .000000001d);

	}
	
	/*
	 * method to test calculateColumnTotal(Values2D data, int column,
             int[] validRows)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values, and an invalid int[] column
	 * 
	 * result should be 0
	 */
	@Test
	public void testCalculateColumnTotalWithInvalidRows() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(1, 0);

				will(returnValue(2.5));

				one(values).getValue(2, 0);

				will(returnValue(-3));

				one(values).getValue(3, 0);

				will(returnValue(-2));
				
				one(values).getValue(4, 0);

				will(returnValue(7));
				
				one(values).getValue(5, 0);

				will(returnValue(-3.5));

			}

		});

		int[] validrows = {10,11,12,14};
		
		double result = DataUtilities.calculateColumnTotal(values, 0, validrows);

		assertEquals(0.0, result, .000000001d);

	}
	/*
	 * method to test calculateColumnTotal(Values2D data, int column,
             int[] validRows)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values, and a null int[] column
	 * 
	 * result should be 0
	 */
	@Test
	public void testCalculateColumnTotalWithValidRowsNullValues() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(null));

				one(values).getValue(1, 0);

				will(returnValue(null));

				one(values).getValue(2, 0);

				will(returnValue(null));

				one(values).getValue(3, 0);

				will(returnValue(-2));
				
				one(values).getValue(4, 0);

				will(returnValue(null));
				
				one(values).getValue(5, 0);

				will(returnValue(-3.5));

			}

		});

		int[] validrows = {0,1,2,4};
		
		double result = DataUtilities.calculateColumnTotal(values, 0, validrows);

		assertEquals(0.0, result, .000000001d);

	}
	
	/*
	 * method to test calculateColumnTotal(Values2D data, int column)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with null values
	 * 
	 * result should be 5
	 */
	@Test
	public void testCalculateColumnTotalWithNullValues() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getRowCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(1, 0);

				will(returnValue(2.5));

				one(values).getValue(2, 0);

				will(returnValue(-3));

				one(values).getValue(3, 0);

				will(returnValue(-2));
				
				one(values).getValue(4, 0);

				will(returnValue(null));
				
				one(values).getValue(5, 0);

				will(returnValue(null));

			}

		});

		
		double result = DataUtilities.calculateColumnTotal(values, 0);

		assertEquals(5.0, result, .000000001d);

	}
	
	/*
	 * method to test calculateRowTotal(Values2D data, int row)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with null values
	 *
	 * 
	 * result method should return 10
	 */
	@Test

	public void calculateRowTotalWithNullValues() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getColumnCount();

				will(returnValue(4));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(0, 1);

				will(returnValue(2.5));

				one(values).getValue(0, 2);

				will(returnValue(null));

				one(values).getValue(0, 3);

				will(returnValue(null));

			}

		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(10.0, result, .000000001d);

	}
	
	/*
	 * method to test calculateRowTotal(Values2D data, int row, int[] validCols)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * and a positive value given for row and a valid int[] for validCols
	 * 
	 * result method should return 8.5
	 */
	@Test

	public void calculateRowTotalWithValidColumns() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getColumnCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(0, 1);

				will(returnValue(2.5));

				one(values).getValue(0, 2);

				will(returnValue(-3));

				one(values).getValue(0, 3);

				will(returnValue(-2));
				
				one(values).getValue(0, 4);

				will(returnValue(5));
				
				one(values).getValue(0, 5);

				will(returnValue(6));

			}

		});

		int[] validcolumns = {0,2,3,5};
		double result = DataUtilities.calculateRowTotal(values, 0, validcolumns);

		assertEquals(8.5, result, .000000001d);

	}
	
	/*
	 * method to test calculateRowTotal(Values2D data, int row, int[] validCols)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * and a positive value given for row and a null for validCols
	 * 
	 * result method should return 13.5
	 */
	@Test

	public void calculateRowTotalWithValidColumnsNullValues() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getColumnCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(0, 1);

				will(returnValue(2.5));

				one(values).getValue(0, 2);

				will(returnValue(null));

				one(values).getValue(0, 3);

				will(returnValue(null));
				
				one(values).getValue(0, 4);

				will(returnValue(5));
				
				one(values).getValue(0, 5);

				will(returnValue(6));

			}

		});

		int[] validcolumns = {0,2,3,5};
		double result = DataUtilities.calculateRowTotal(values, 0, validcolumns);

		assertEquals(13.5, result, .000000001d);

	}
	
	/*
	 * method to test calculateRowTotal(Values2D data, int row, int[] validCols)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock Values2D objects
	 * a valid Values2D mock is done with valid values
	 * and a positive value given for row and an invalid int[] for validCols
	 * 
	 * result method should return 0
	 */
	@Test

	public void calculateRowTotalWithInValidColumns() {

		Mockery mockingContext = new Mockery();

		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {

			{

				one(values).getColumnCount();

				will(returnValue(6));

				one(values).getValue(0, 0);

				will(returnValue(7.5));

				one(values).getValue(0, 1);

				will(returnValue(2.5));

				one(values).getValue(0, 2);

				will(returnValue(-3));

				one(values).getValue(0, 3);

				will(returnValue(-2));
				
				one(values).getValue(0, 4);

				will(returnValue(5));
				
				one(values).getValue(0, 5);

				will(returnValue(6));

			}

		});

		int[] validcolumns = {10,22,13,15};
		double result = DataUtilities.calculateRowTotal(values, 0, validcolumns);

		assertEquals(0, result, .000000001d);

	}
	
	/*
	 * method to test getCumulativePercentage(keyedValues values)
	 * in DataUtilities Class
	 * 
	 * Jmock is used to mock keyedValues objects
	 * a valid keyedValues mock is done with null values
	 * 
	 * result method should return a keyedValues object containing the correct cumulative percentages
	 */
	@Test

	public void testGetCumulativePercentageWithNullValues() {

		Mockery mockingContext = new Mockery();

		final KeyedValues values = mockingContext.mock(KeyedValues.class);

		mockingContext.checking(new Expectations() {

			{

				allowing(values).getItemCount();

				will(returnValue(3));

				allowing(values).getKeys();

				will(returnIterator(0, 1, 2));

				allowing(values).getValue(0);

				will(returnValue(2));

				allowing(values).getValue(1);

				will(returnValue(null));

				allowing(values).getValue(2);

				will(returnValue(2));

				allowing(values).getKey(0);

				will(returnValue(0));

				allowing(values).getKey(1);

				will(returnValue(1));

				allowing(values).getKey(2);

				will(returnValue(2));

			}

		});

		Mockery mocking = new Mockery();

		final KeyedValues expectedOutput = mocking.mock(KeyedValues.class);

		mocking.checking(new Expectations() {

			{

				one(expectedOutput).getItemCount();

				will(returnValue(3));

				one(expectedOutput).getKeys();

				will(returnIterator(0, 1, 2));

				one(expectedOutput).getValue(0);

				will(returnValue(0.50));

				one(expectedOutput).getValue(1);

				will(returnValue(0.50));

				one(expectedOutput).getValue(2);

				will(returnValue(1.0));

			}

		});

		KeyedValues actualOutput = DataUtilities.getCumulativePercentages(values);

		assertEquals(expectedOutput.getValue(0), actualOutput.getValue(0));

		assertEquals(expectedOutput.getValue(1), actualOutput.getValue(1));

		assertEquals(expectedOutput.getValue(2), actualOutput.getValue(2));

	}
		
}