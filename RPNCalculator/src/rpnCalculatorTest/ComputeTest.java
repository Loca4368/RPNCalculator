package rpnCalculatorTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.DivisionByZeroException;
import exceptions.InsufficientNumberException;
import exceptions.InvalidElementException;
import rpn.RPNCalculator;

public class ComputeTest {


	RPNCalculator rpnCalculator;
	
	String input;
	
	@Before
	public void setUp()
	{
		rpnCalculator =  new RPNCalculator();
	}
	
	//Test for Compute() Method
	//Conditions" 1: ""hello" => Throw Exception", 2: "5 2" => Stack "5 2",  3: "2 sqrt" => "1.4142135623730951",
	//			  4: "5 4 3 2 undo undo *" => "20",, 5: "7 12 2 / -" => "1", 6: "1 2 clear" => "Empty Stack", 
	//			  7: "1 2 3 4 5 * * * " => "120", 8: "1 2 3 * 5 + * * 6 5" => "11",
	//			  
	
	
	@Test(expected = InvalidElementException.class)
	public void testComputeConditionOne() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException{
		
		input ="hello";
		rpnCalculator.compute(input);
	}
	
	@Test
	public void testComputeConditionTwo() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		input = "5 2";
		rpnCalculator.compute(input);
		Double excpetedResult1 = (double) 2;
		Double excpetedResult2 = (double) 5;
		
		assertEquals(excpetedResult1,rpnCalculator.getCalcStack().pop());
		assertEquals(excpetedResult2,rpnCalculator.getCalcStack().pop());
	}
	
	@Test
	public void testComputeConditionThree() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		
		
		input = "2 sqrt";
		rpnCalculator.compute(input);
		Double excpetedResult = 1.4142135623730951;
		
		assertEquals(excpetedResult,rpnCalculator.getCalcStack().pop());
	}
	

	@Test
	public void testComputeConditionFour() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		input = "5 4 3 2 undo undo *";
		rpnCalculator.compute(input);
		Double excpetedResult = (double) 20;
		
		assertEquals(excpetedResult,rpnCalculator.getCalcStack().pop());
	}
	
	@Test
	public void testComputeConditionFive() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		input = "7 12 2 / -";
		rpnCalculator.compute(input);
		Double excpetedResult = (double) 1;
		
		assertEquals(excpetedResult,rpnCalculator.getCalcStack().pop());
	}
	
	@Test
	public void testComputeConditionSix() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		input = "1 2 clear";
		rpnCalculator.compute(input);
		
		assertTrue(rpnCalculator.getCalcStack().isEmpty());
	}
	
	@Test
	public void testComputeConditionSeven() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		input = "1 2 3 4 5 * * * ";
		rpnCalculator.compute(input);
		Double excpetedResult = (double) 120;
		assertEquals(excpetedResult,rpnCalculator.getCalcStack().pop());
	}
	
	@Test
	public void testComputeConditionEight() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException 
	{
		input = "1 2 3 * 5 + * * 6 5";
		rpnCalculator.compute(input);
		Double excpetedResult = (double) 11;
		assertEquals(excpetedResult,rpnCalculator.getCalcStack().pop());
	}
	
	@After
	public void tearDown()
	{
		System.out.println("After Test");
	}

}
