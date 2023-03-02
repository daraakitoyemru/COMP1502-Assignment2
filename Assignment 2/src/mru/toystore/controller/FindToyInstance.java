package mru.toystore.controller;

import java.util.ArrayList;

import mru.toystore.model.Animal;
import mru.toystore.model.Figure;
import mru.toystore.model.Puzzle;
import mru.toystore.model.Toy;

public class FindToyInstance {

	public void findToy(ArrayList<Toy> toys){
		
		for (Toy toy : toys) {
			if (toy instanceof Figure) {
				System.out.println(((Figure)toy).toString());
			}
			else if (toy instanceof Puzzle) {
				System.out.println(((Puzzle)toy).toString());
			}
			else if (toy instanceof Animal) {
				System.out.println(((Animal)toy).toString());
			}
		}
		
		
		
	}
}
