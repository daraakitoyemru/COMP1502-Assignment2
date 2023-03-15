package mru.toystore.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.toystore.model.Figure;


class FigureTest {
	Figure figure = new Figure("4512345679", "Action figure", "Rubix", "12.99", 4, "5","D");
	
	@Test
	void setClassificationTest() {
		figure.setClassification("M");
		String test = "D";
		
		assertNotEquals(test, figure.getClassification());
	}

}