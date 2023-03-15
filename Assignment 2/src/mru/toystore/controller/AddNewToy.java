package mru.toystore.controller;

import java.util.ArrayList;
import java.util.Scanner;


import mru.toystore.exceptions.InvalidFormatException;
import mru.toystore.exceptions.SmallerMaximumNumofPlayerException;
import mru.toystore.view.AddNewToyMenu;
import mru.toystore.view.StoreMenu;

public class AddNewToy {
	
	
	private StoreMenu storeMenu;
	private AddNewToyMenu menu;
	Scanner input;

	public AddNewToy() {
		
		storeMenu = new StoreMenu();
	 	menu = new AddNewToyMenu();
		input = new Scanner(System.in);
	
		
	}
	
	/**
	 * Asks users to enter a serial number and checks if the format is correct
	 * @return valid serial number
	 * @throws InvalidFormatException
	 * */
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
	/**
	 * Asks user to enter the min/max number of players for a board game. 
	 * @return min and max num of player in a list
	 * @throws SmallerMaximumNumofPlayerException when max player is less than minimum players
	 * */
	public ArrayList<String> validateNumOfPlayers() throws SmallerMaximumNumofPlayerException{
		ArrayList<String> data = new ArrayList<>();
		String minPlayers = menu.promptMinNumofPlayers();
		String maxPlayers = menu.promptMaxNumofPlayers();
		
	
		if (Integer.parseInt(maxPlayers) <= Integer.parseInt(minPlayers)) {
			throw new SmallerMaximumNumofPlayerException();
		}else {
			data.add(minPlayers);
			data.add(maxPlayers);
		}
		return data;
	}
	
	/**
	 * Formats the number of player into a String
	 * @return formatted players
	 * */
	public String formatPlayers() {
		ArrayList<String> data = null;
		boolean flag = true;
		while(flag) {
			try {
				data = validateNumOfPlayers();
				flag = false;
			} catch (SmallerMaximumNumofPlayerException e) {
				// TODO Auto-generated catch block
				System.out.println("\n\t" + e.getMessage() + ". Please try again.");
				continue;
			}
		}
		
		
		return data.get(0)+"-"+data.get(1);
				
	}
	
	
	public String validatePrice() {
		String price = menu.promptPrice();
		
		if(!price.contains(".")) {
			return price + ".00";
		} 
		return price;
	}

	
	
	/**
	 * Adds all of the data shared across all toys into a list
	 * @return list of strings containing valid toy data
	 * */
	public ArrayList<String> newToyData(){
		ArrayList<String> data = new ArrayList<>();
		String name = storeMenu.promptToyName();
		String brand = menu.promptBrandName();
		String price = validatePrice();
		String inventory = menu.promptInventory();
		String ageRating = menu.promptAgeRating();
		
		
		
		data.add(name);
		data.add(brand);
		data.add(price);
		data.add(inventory);
		data.add(ageRating);
		
		return data;
	}
	/**
	 * Displays a different set of prompts depending on the users serial number
	 * @return a list of data containing user input
	 * */
	public ArrayList<String> toyData(String sn){
		
		ArrayList<String> data = newToyData();
		if (sn.charAt(0) == '0' || sn.charAt(0) == '1') {
			char classification = menu.promptClassifaction();
			data.add(Character.toString(classification));
		} else if (sn.charAt(0) == '2' || sn.charAt(0) == '3') {
			String material = menu.promptMaterial();
			char size = menu.promptSize();
			data.add(material);
			data.add(Character.toString(size));
		} else if (sn.charAt(0) == '4' || sn.charAt(0) == '5' || sn.charAt(0) == '6') {
			char puzzleType = menu.promptPuzzleType();
			data.add(Character.toString(puzzleType));
		} else {
			String numOfPlayers = formatPlayers();
			String designers = menu.promptDesigners();
	 		data.add(numOfPlayers);
			data.add(designers);
		}
		
		return data;
	}
}
