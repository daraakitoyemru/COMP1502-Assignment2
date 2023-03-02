package mru.toystore.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.toystore.model.Animal;
import mru.toystore.model.Figure;
import mru.toystore.model.Puzzle;
import mru.toystore.model.Toy;
import mru.toystore.view.StoreMenu;

public class StoreManager {

	
	private StoreMenu menu;
	private ArrayList<Toy> toys;
	private FindToyInstance findToy;
	private final String FILE_PATH  = "res/toys.txt";
	
	public StoreManager() {
		menu = new StoreMenu();
		toys = new ArrayList<>();
		findToy = new FindToyInstance();
		
		menu.showWelcomeBanner();
		loadData();
		launchApp();
	}
	
	
	/**
	 * Launches the application
	 * */
	private void launchApp() {
		
		boolean flag = true;
		
		while (flag) {
		
				String option = menu.showMainMenu();
				
				switch (option) {
				case "1":
					Search();
					flag = false;
					break;
				case "2":
					System.out.println("Adding a toy");
					flag = false;
					break;
				case "3":
					System.out.println("Removing a toy");
					flag = false;
					break;
				case "4":
					System.out.println("savinggg...");
					menu.showThankYou();
					flag = false;
					break;
				default:
					//menu.validateMenuOption(option);
					menu.showErrMsg();
					
					continue;
				}
		}
	}

	


	/**
	 * Launches menu for Search and Purchase option
	 * */
	private void Search() {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		while (flag) {
				String option = menu.showSubMenu();
				
				switch (option) {
				case "1":
					System.out.println("Seriul number plsss");
					searchBySerialNum();
					//flag = false;
					break;
				case "2":
					System.out.println("toy name plss");
			
					flag = false;
					break;
				case "3":
					System.out.println("toy type pleesse");
					flag = false;
					break;
				case "4":
					//System.out.println("Byeeee");
					launchApp();
					flag = false;
					break;
				default:
					menu.showErrMsg();
					
					continue;
				}
		}
	}
	
	/**
	 * Checks for toy match and displays matched toy
	 * */
	private void searchBySerialNum() {
		//test 1147205649
		// TODO Auto-generated method stub
		String sn = menu.promptSerialNum();
		
		Toy result = findBySn(sn);
		

			if (result != null) {
				
				System.out.println("\n"+result.toString());
				purchaseBySn(result);
				
			} else {
				System.out.println("not found");
			}
		
	}
	
	/**
	 * @param sn accepts serial number for toy
	 * @return matching toy object if found or null if not found
	 * */
	private Toy findBySn(String sn) {
		for (Toy toy: toys) {
			if (sn.equals(toy.getSerialNumber())){
				return toy;
			} 
		}
		return null;
	}

	/**
	 * Prompts user if they want to purchase searched toy. If 'y' is entered, searched toy is removed from toys database
	 *@param accepts a Toy object
	 * */
	private void purchaseBySn(Toy t) {
		char option = menu.promptAreYouSure();
		
		
		if (option == 'y') {
			
			purchaseToy(t);
		} else if (option == 'n') {
			System.out.println("Add enter to continue thing");
		} else {
			menu.showErrMsg();
		}
	}

	//add javadoc comments
	private int purchaseToy(Toy toy) {
		int inventory = toy.getAvailibility();
		if(inventory >= 1) {
			System.out.println("Purchase sucessful!");
			toy.setAvailibility(inventory - 1);
		} else {
			System.out.println("Out of stock!");
		}
		return inventory;
	}
	
	private void loadData() {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splitLine;
		
		if (db.exists()) {
			try {
				Scanner fileReader = new Scanner(db);
				
				while (fileReader.hasNextLine()) {
					currentLine = fileReader.nextLine();
					splitLine = currentLine.split(";");
					
					//Checks serial number, creates object of corresponding toy
					if (splitLine[0].charAt(0) == '0' || splitLine[0].charAt(0) == '1') {
						Figure figure = new Figure(splitLine[0], splitLine[1], splitLine[2], splitLine[3], Integer.parseInt(splitLine[4]), splitLine[5], splitLine[6]);
						toys.add(figure);
					}
					else if (splitLine[0].charAt(0) == '2' || splitLine[0].charAt(0) == '3') {
						Animal animal = new Animal(splitLine[0], splitLine[1], splitLine[2], splitLine[3], Integer.parseInt(splitLine[4]), splitLine[5], splitLine[6], splitLine[7]);
						toys.add(animal);
					}
					else if (splitLine[0].charAt(0) == '4' || splitLine[0].charAt(0) == '5' || splitLine[0].charAt(0) == '6') {
						Puzzle puzzle = new Puzzle(splitLine[0], splitLine[1], splitLine[2], splitLine[3], Integer.parseInt(splitLine[4]), splitLine[5], splitLine[6]);
						toys.add(puzzle);
					}
					//Add board game
				}
				fileReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found. Try checking your file path");
			}
			
		}
		
	
	}
	

}
