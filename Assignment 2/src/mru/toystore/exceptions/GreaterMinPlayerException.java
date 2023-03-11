package mru.toystore.exceptions;

public class GreaterMinPlayerException extends Exception{

	public GreaterMinPlayerException() {
		super("Minimum number of players cannot equal nor exceed maximum number of players");
	}
}
