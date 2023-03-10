package mru.toystore.exceptions;

public class ExistingSerialNumException extends Exception {

	public ExistingSerialNumException() {
		super("This toy already exists");
	}
}
