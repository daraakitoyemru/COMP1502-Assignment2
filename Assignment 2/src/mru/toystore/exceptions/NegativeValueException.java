package mru.toystore.exceptions;

public class NegativeValueException extends Exception {

	public NegativeValueException() {
		super("Price must be positive");
	}
}
