package mru.toystore.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.toystore.model.Puzzle;

class PuzzleTest {
	Puzzle puzzle = new Puzzle("4512345679", "Puzzle Game", "Rubix", "12.99", 4, "5","M");
	@Test
	void setNameTest() {
		puzzle.setName("Namco");
		String test = "Puzzle Game";
		
		assertNotEquals(test, puzzle.getName());
		
	}
	
	@Test
	void setSerialNumTest() {
		puzzle.setSerialNumber("5123456789");
		String test = "5123456789";
		
		assertEquals(test, puzzle.getSerialNumber());
		
	}

	@Test
	void setPriceTest() {
		puzzle.setPrice("47.00");
		String test = "12.99";
		
		assertNotEquals(test, puzzle.getPrice());
		
	}
	

	@Test
	void setInventoryTest() {
		puzzle.setAvailibility(2);
		int test = 2;
		
		assertEquals(test, puzzle.getAvailibility());
		
	}
	

	@Test
	void setAgeRatingTest() {
		puzzle.setAgeRating("4");
		String test = "4";
		
		assertEquals(test, puzzle.getAgeRating());
		
	}
	
	@Test
	void setPuzzleTypeTest() {
		puzzle.setPuzzleType("C");
		String test = "M";
		
		assertNotEquals(test, puzzle.getPuzzleType());
		
	}
}

