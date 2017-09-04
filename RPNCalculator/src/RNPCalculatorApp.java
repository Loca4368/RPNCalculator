/*
 * Author: Ming Qiu
 * 
 */
import java.util.EmptyStackException;
import java.util.Scanner;
import exceptions.DivisionByZeroException;
import exceptions.InsufficientNumberException;
import exceptions.InvalidElementException;
import rpn.RPNCalculator;
public class RNPCalculatorApp
{
	public static void main(String[] args)
    {
		
    	System.out.println("Starting RPN Calculator");
    	RPNCalculator rpnCalculator = new RPNCalculator();
    	System.out.println("eg: 5 2 +");
    	Scanner scan = new Scanner(System.in);
        
        String s;  
        for (int i = 0; i < 1000000; i++) {  
            
        	//Get user input
        	s = scan.nextLine();
        	
        	//Call compute() method to process input and catch corresponding exceptions 
        	try
        	{
        		rpnCalculator.compute(s);
        	}
        	
        	catch(EmptyStackException e)
        	{
        		System.out.println(e.getMessage());
        	}
        	
        	catch(InsufficientNumberException e)
        	{
        		System.out.println(e.getMessage());
        	} 
        	catch (InvalidElementException e) {
				
        		System.out.println(e.getMessage());
			} 
        	catch (DivisionByZeroException e) {
				
				System.out.println(e.getMessage());
			}
			
        	//Display Stack
        	rpnCalculator.printStack();
        	
        	//Put Input on new line
        	System.out.print("\n");
        }
        	
        	
        	scan.close();
    }
}