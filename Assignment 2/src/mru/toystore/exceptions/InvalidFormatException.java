package mru.toystore.exceptions;

public class InvalidFormatException extends Exception {

	public InvalidFormatException() {
		super("Serial number must contain only digits");
	}
	
	public InvalidFormatException(String sn) {
		super("Out of bounds for: " + sn + ". Serial number must 10 digits");
	}
	
	
}
