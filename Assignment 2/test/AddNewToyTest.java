//package mru.toystore.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mru.toystore.controller.AddNewToy;
import mru.toystore.exceptions.InvalidFormatException;
import mru.toystore.exceptions.SmallerMaximumNumofPlayerException;

class AddNewToyTest {
	AddNewToy newToy = new AddNewToy();

	@Test
	// credit to https://howtodoinjava.com/junit5/expected-exception-example/
	void validateSnDigitTest() {
		 
		String errMsg = "Serial number must contain only digits";
		InvalidFormatException e = Assertions.assertThrows(InvalidFormatException.class, () -> {
			
			newToy.validateSn();
	 		
		}, "InvalidFormatException was expected");
		
		assertEquals(errMsg, e.getMessage());
	}

	@Test
	void validateNumOfPlayersTest() {
		String errMsg = "Maximun number of players cannot be less than nor equal to minimum number of players";
		SmallerMaximumNumofPlayerException e = assertThrows(SmallerMaximumNumofPlayerException.class, () -> {
			newToy.validateNumOfPlayers();
		},"SmallerMaximumNumofPlayerException was expected" );
	
		assertEquals(errMsg, e.getMessage());
	}
	
	
	
}
