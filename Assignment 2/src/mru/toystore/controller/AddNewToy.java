package mru.toystore.controller;

import java.util.ArrayList;
import java.util.Scanner;

import mru.toystore.exceptions.InvalidFormatException;
import mru.toystore.model.Toy;
import mru.toystore.view.AddNewToyMenu;
import mru.toystore.view.StoreMenu;

public class AddNewToy {
	
	
	private StoreMenu storeMenu;
	private AddNewToyMenu newToy;
	Scanner input;

	public AddNewToy() {
		
		storeMenu = new StoreMenu();
		newToy = new AddNewToyMenu();
		input = new Scanner(System.in);
	
		
	}
	
	
	public String validateSn() throws InvalidFormatException {
		String sn = storeMenu.promptSerialNum();
		
		if (!sn.matches("[0-9]+")) {
			throw new InvalidFormatException();
		} else if (sn.length() != 10) {
			throw new InvalidFormatException(sn);
		}  else {
			return sn;
		}
	}
	
	
	public String validatePrice() {
		String price = newToy.promptPrice();
		
		if(!price.contains(".")) {
			return price + ".00";
		} 
		return price;
	}

	
	public ArrayList<String> newToyData(){
		ArrayList<String> data = new ArrayList<>();
		String name = storeMenu.promptToyName();
		String brand = newToy.promptBrandName();
		String price = validatePrice();
		String inventory = newToy.promptInventory();
		String ageRating = newToy.promptAgeRating();
		
		
		
		data.add(name);
		data.add(brand);
		data.add(price);
		data.add(inventory);
		data.add(ageRating);
		
		return data;
	}
	
	public ArrayList<String> toyData(String sn){
		
		ArrayList<String> data = newToyData();
		if (sn.charAt(0) == '0' || sn.charAt(0) == '1') {
			char classification = newToy.promptClassifaction();
			data.add(Character.toString(classification));
		} else if (sn.charAt(0) == '2' || sn.charAt(0) == '3') {
			String material = newToy.promptMaterial();
			char size = newToy.promptSize();
			data.add(material);
			data.add(Character.toString(size));
		} else if (sn.charAt(0) == '4' || sn.charAt(0) == '5' || sn.charAt(0) == '6') {
			char puzzleType = newToy.promptPuzzleType();
			data.add(Character.toString(puzzleType));
		}
		
		return data;
	}
}
