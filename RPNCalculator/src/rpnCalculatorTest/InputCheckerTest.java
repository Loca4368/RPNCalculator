package rpnCalculatorTest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rpn.RPNCalculator;

public class InputCheckerTest {
	
	RPNCalculator rpnCalculator;
	
	@Before
	public void setUp()
	{
		rpnCalculator =  new RPNCalculator();
	}
	
	//Test for IsNum() Method
	//Conditions" 1: "+" => false", 2: "1" => true", 3: "clear" => false"
	@Test
	public void testIsNumConditionOne()
	{
		String input = "+";
		
		assertFalse(rpnCalculator.isNumber(input));
	}
	
	@Test
	public void testIsNumConditionTwo()
	{
		String input = "1";
		assertTrue(rpnCalculator.isNumber(input));
	}
	
	@Test
	public void testIsNumConditionThree()
	{
		String input = "clear";
		
		assertFalse(rpnCalculator.isNumber(input));
	}
	
	//Test for IsCommonOperator() Method
	//Conditions" 1: "1" => false", 2: "/" => true", 3: "undo" => false"
	@Test
	public void testIsCommonOperatorConditionOne()
	{
		String input = "1";
		assertFalse(rpnCalculator.isCommonOperator(input));
	}
	
	@Test
	public void testIsCommonOperatorConditionTwo()
	{
		String input = "/";
		assertTrue(rpnCalculator.isCommonOperator(input));
	}
	@Test
	public void testIsCommonOperatorConditionThree()
	{
		String input = "undo";
		assertFalse(rpnCalculator.isCommonOperator(input));
	}
	
	//Test for IsCustomOperator() Method
	//Conditions" 1: "1" => false", 2: "/" => false", 3: "undo" => true",
	//			  4: "clear" => true", 5: "sqrt" => true"
	@Test
	public void testIsCustomOperatorConditionOne()
	{
		String input = "1";
		assertFalse(rpnCalculator.isCustomOperator(input));
	}
	
	@Test
	public void testIsCustomOperatorConditionTwo()
	{
		String input = "/";
		assertFalse(rpnCalculator.isCustomOperator(input));
	}
	
	@Test
	public void testIsCustomOperatorConditionThree()
	{
		String input = "undo";
		assertTrue(rpnCalculator.isCustomOperator(input));
	}
	
	@Test
	public void testIsCustomOperatorConditionFour()
	{
		String input = "clear";
		assertTrue(rpnCalculator.isCustomOperator(input));
	}
	
	@Test
	public void testIsCustomOperatorConditionFive()
	{
		String input = "sqrt";
		assertTrue(rpnCalculator.isCustomOperator(input));
	}
	
	//Test for isNumSufficient() Method
	//Conditions" 1: "Empty Stack" => True", 2: "One element" => false", 3: "two elements" => true",
	//			  4: "More thant two elements" => true",
	@Test
	public void isNumSufficientConditionOne()
	{
		assertTrue(rpnCalculator.getCalcStack().isEmpty());
	}
	
	@Test
	public void isNumSufficientConditionTwo()
	{
		rpnCalculator.getCalcStack().push((double) 5);
		
		assertFalse(rpnCalculator.isNumSufficient());
	}
	
	@Test
	public void isNumSufficientConditionThree()
	{
		rpnCalculator.getCalcStack().push((double) 5);
		rpnCalculator.getCalcStack().push((double) 3);
		assertTrue(rpnCalculator.isNumSufficient());
	}
	
	@Test
	public void isNumSufficientConditionFour()
	{
		rpnCalculator.getCalcStack().push((double) 5);
		rpnCalculator.getCalcStack().push((double) 3);
		rpnCalculator.getCalcStack().push((double) 9);
		assertTrue(rpnCalculator.isNumSufficient());
	}
	
	@After
	public void tearDown()
	{
		System.out.println("After Test");
	}
}
