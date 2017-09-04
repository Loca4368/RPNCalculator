package rpnCalculatorTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exceptions.DivisionByZeroException;
import exceptions.InsufficientNumberException;
import exceptions.InvalidElementException;
import rpn.RPNCalculator;


public class ExceptionHandleTest {

	RPNCalculator rpnCalculator;
	
	@Before
	public void setUp()
	{
		rpnCalculator =  new RPNCalculator();
	}
	
	//Exception Test
	@Test(expected = DivisionByZeroException.class)
	public void testComputeDividedByZero() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException
	{
		String input;
		input ="1 0 /";
		rpnCalculator.compute(input);
			
	}
		
	@Test(expected = InvalidElementException.class)
	public void testComputeInvalidElement() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException
	{
		String input;
		input ="helloworld";
		rpnCalculator.compute(input);
	}
	
//	@Test(expected = InsufficientNumberException.class)
//	public void testComputeInsufficientNumber() throws InvalidElementException, DivisionByZeroException, InsufficientNumberException
//	{
//		String input;
//		input ="1 /";
//		rpnCalculator.compute(input);
//	}
	
	@After
	public void tearDown()
	{
		System.out.println("After Test");
	}


}
