package Exceptions;

@SuppressWarnings("serial")
public class NegativeCostException extends Exception{
	public NegativeCostException(String message){
		super(message);
}
}