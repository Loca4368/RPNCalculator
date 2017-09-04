package exceptions;

import java.io.Serializable;

//Non Serialable//
public class DivisionByZeroException extends Exception implements Serializable{
	
//	NonSerializableClass NonSerializableClass;
	
//	public DivisionByZeroException()
//	{
//		this.
//		//this.setNonSerializableProperty(new NonSerializableProperty());
//	}
	
	public DivisionByZeroException(String msg)
	{
		//setNonSerializablePropety(new setNonSerializablePropety(msg));
		super(msg);
	}
	

}
