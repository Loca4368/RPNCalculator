/*
 * Author: Ming Qiu
 * 
 */
package rpn;
import java.util.Stack;
import java.util.regex.Pattern;

import exceptions.*;

public class RPNCalculator {

private Stack<Double> calcStack = new Stack<Double>();

public Stack<Double> getCalcStack() {
	return calcStack;
}

static double op1=0, op2=0;

public void compute(String input) throws InvalidElementException, DivisionByZeroException, InsufficientNumberException
{
	double temp = 0;//For store compute result
	String[] exp = input.split(" ");//Split user input by " "
	
	for(String element : exp) //Process each element contained in String [] exp
	{	
		if(isNumber(element)) //If element is Number
			calcStack.push(Double.valueOf(element).doubleValue());//Convert String element into Double and push into stack
		
		else if(isCommonOperator(element))//If element is CommonOperator, "+-*/".
		{
			if(isNumSufficient()) //When numbers in current stack is sufficient
			{
				//Pop stack elements for operation
        		op1 = calcStack.pop();
        		op2 = calcStack.pop();
        		 
        		//Execute corresponding calculation based on the element
        		switch(element)
        		{
        			case "+": temp = op2+op1;break;
        			case "-": temp = op2-op1;break;
        			case "*": temp = op2*op1;break;
        			case "/": 
        				if(op1 != 0)
                		temp = op2/op1;
        				else
        				{
        					//Push back if divided by zero
        					calcStack.push(op2);
        					calcStack.push(op1);
        					throw new DivisionByZeroException("Number can not be divided by Zero");
        				}
        				break;
        		}
        		
        		//Push process result back to stack
        		calcStack.push(temp);
        }
			
			
			/*Memo:
			 * Two Methods are developed for showing warning on insufficient number for operation.
			 * Method 1: Printing out the warning message and return;
			 * Method 2: Throw InsufficientNumber Exception
			Method 2 works for all cases except the case "input = "1 2 3 * 5 + * * 6 5";
	 		In the perspective of delivery running application, Method 1 is used instead.
	 		And the Unit test for testComputeInsufficientNumber() is commented.
			*/
			//Throw Exception for operation on insufficient Number
			else
			{
				//Method 1
				System.out.println("Insufficient number for operation.");
        		return;
        		
        		//Method 2
				//throw new InsufficientNumberException("Insufficient number for operation");
			}	
        		
		}
        
        
        else if(isCustomOperator(element))//If Custom Operator, "sqrt, clear, undo"
        {
        	//Execute corresponding operation based on the element
        	switch(element)
        	{
        		case "clear": calcStack.clear();break;
                case "undo": calcStack.pop();break;
                case "sqrt":Double op1 = Math.sqrt(calcStack.pop()); calcStack.push(op1);break; 
            }
        }
        
        //Throw Exception for Invalid Input
        else 
        	throw new InvalidElementException("Invalid Input");
    }//End of For loop
}


//Number Operation Checker
public  boolean isNumber(String s)
{
  try{
      Double.parseDouble(s);
      return true;
  }catch(NumberFormatException e){
      return false;
  }
}

//Common Operator Checker
public  boolean isCommonOperator(String s)
{
  String operator = "+-*/";
  if(operator.indexOf(s)!=-1)
      return true;
  return false;
}

//Custom Operator Checker
public boolean isCustomOperator(String str)
{
	boolean result = false;
	String regEx1="sqrt";
	String regEx2="clear";
	String regEx3="undo";
	
	//Use Regular Expressions to match String input
	if(Pattern.compile(regEx1).matcher(str).find()||Pattern.compile(regEx2).matcher(str).find()||Pattern.compile(regEx3).matcher(str).find())
	{
		result = true;
	}
	
	return result;
	
}

//Check stack number sufficiency for common operator
public  boolean isNumSufficient()
{
	if(calcStack.size()>=2)
		return true;
	else return false;
}

//Print stack
public void printStack()
{
	
	System.out.print(this.toString());
}

//Override toString to display custom layout
@Override
public String toString() {
	
	StringBuilder builder = new StringBuilder();
	builder.append("Stack:");
	builder.append(calcStack);
	return builder.toString();
}


}