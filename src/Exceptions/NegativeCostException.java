package Exceptions;
//This exception prevents a negative cost from existing

@SuppressWarnings("serial")
public class NegativeCostException extends Exception{
	public NegativeCostException(String message){
		super(message);
}
}