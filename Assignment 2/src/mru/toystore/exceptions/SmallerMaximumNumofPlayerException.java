package mru.toystore.exceptions;

public class SmallerMaximumNumofPlayerException extends Exception{
	 
	public SmallerMaximumNumofPlayerException() {
		super("Maximun number of players cannot be less than nor equal to minimum number of players");
	}
}
