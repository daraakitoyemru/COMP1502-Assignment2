package mru.toystore.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import mru.toystore.exceptions.InvalidFormatException;
import mru.toystore.model.Animal;
import mru.toystore.model.BoardGame;
import mru.toystore.model.Figure;
import mru.toystore.model.Puzzle;
import mru.toystore.model.Toy;
import mru.toystore.view.AddNewToyMenu;
import mru.toystore.view.StoreMenu;

public class StoreManager {

	
	private StoreMenu menu;
	private AddNewToy newToy;
	private AddNewToyMenu newToyMenu;
	public ArrayList<Toy> toys;
	private FindToyInstance findToy;
	private final String FILE_PATH  = "res/toys.txt";
	
	public StoreManager() {
		menu = new StoreMenu();
		newToy = new AddNewToy();
		newToyMenu = new AddNewToyMenu();
		toys = new ArrayList<>();
		findToy = new FindToyInstance();
		
		menu.showWelcomeBanner();
		loadData();
		launchApp();
		
	}
	
	
	/**
	 * Launches the application
	 * @throws InvalidFormatException 
	 * */
	private void launchApp()  {
		
		boolean flag = true;
		
		while (flag) {
		
				String option = menu.showMainMenu();
				
				switch (option) {
				case "1":
					Search();
					flag = false;
					break;
				case "2":
					addNewToy();
					//flag = false;
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

	


	private void addNewToy() {
		// TODO Auto-generated method stub
		
		boolean flag = true;
		
		while(flag) {
			try {
				
				String sn = newToy.validateSn();
				ArrayList<String> newToyData = newToy.toyData(sn);
				if (checkSn(sn)) {
					System.out.println("Exists");
					continue;
				}else if (sn.charAt(0) == '0' || sn.charAt(0) == '1') {
					Figure figure = new Figure(sn, newToyData.get(0),newToyData.get(1), newToyData.get(2),Integer.parseInt(newToyData.get(3)),newToyData.get(4),newToyData.get(5));
					toys.add(figure);
					newToyMenu.showAddedToyMsg();
					menu.promptContinue();
					break;
				} else if (sn.charAt(0) == '2' || sn.charAt(0) == '3') {
					Animal animal = new Animal(sn,newToyData.get(0),newToyData.get(1), newToyData.get(2),Integer.parseInt(newToyData.get(3)),newToyData.get(4),newToyData.get(5), newToyData.get(6));
					toys.add(animal);
					newToyMenu.showAddedToyMsg();
					menu.promptContinue();
					break;
				} else if (sn.charAt(0) == '4' || sn.charAt(0) == '5' || sn.charAt(0) == '6') {
					Puzzle puzzle = new Puzzle(sn, newToyData.get(0),newToyData.get(1), newToyData.get(2),Integer.parseInt(newToyData.get(3)),newToyData.get(4),newToyData.get(5));
					toys.add(puzzle);
					newToyMenu.showAddedToyMsg();
					menu.promptContinue();
					break;
				}
				
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
	}


	private boolean checkSn(String sn) {
		for (Toy toy : toys) {
			if (sn.equals(toy.getSerialNumber())) {
				return true;
			} 
		}
		return false;
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
					searchBySerialNum();
					//flag = false;
					break;
				case "2":
					System.out.println("toy name plss");
					searchByName();
					//flag = false;
					break;
				case "3":
					System.out.println("toy type pleesse");
					searchByCategory();
					//flag = false;
					break;
				case "4":
					launchApp();
					flag = false;
					break;
				default:
					menu.showErrMsg();	
					continue;
				}
		}
	}
	
	//add doc
	private void searchByCategory() {
		String toyType = menu.promptCategoryName();
		
		ArrayList<Toy> matches = findByCategory(toyType);
		
		boolean flag = true;
		
		while(flag) {

			if (matches.size() != 0) {
				formatToy(matches);
				
				String option = menu.promptPurchaseOption();
				if (Integer.parseInt(option) <= matches.size() && Integer.parseInt(option) != 0) {
					System.out.println("\nSelected toy: " + matches.get(Integer.parseInt(option) - 1));
					purchaseToy(matches.get(Integer.parseInt(option) - 1));
					flag = false;
				} else {
					System.out.println("\n********Please enter a number within range*********\n");
					
					continue;
				}
				
			}
			else {
				System.out.println("not found");
				flag = false;
			}
		}
		
	}
	
	//add javadoc
	private void formatToy(ArrayList<Toy> toyList) {
		for (int i = 0; i < toyList.size(); i++) {
			System.out.println("("+(i + 1)+")" + " " + toyList.get(i).toString());
		}
		
	}
	
	
	//add javadoc
	private void searchByName() {
		// TODO Auto-generated method stub
		String name = menu.promptToyName();
		ArrayList<Toy> matches = findByName(name);
		
		boolean flag = true;
		
		while(flag) {

			if (matches.size() != 0) {
				formatToy(matches);	
				String option = menu.promptPurchaseOption();
				
				if (Integer.parseInt(option) <= matches.size() && Integer.parseInt(option) != 0) {
					System.out.println("\nSelected toy: " + matches.get(Integer.parseInt(option) - 1));
					purchaseToy(matches.get(Integer.parseInt(option) - 1));
					flag = false;
				} else {
					System.out.println("\n********Please enter a number within range*********\n");
					
					continue;
				}
			}
			else {
				System.out.println("not found");
				flag = false;
			}
		}	
		
	}
	
	
	/**
	 * Checks for toy match and displays matched toy
	 * */
	private void searchBySerialNum() {
		//test 
		// TODO Auto-generated method stub
		String sn = menu.promptSerialNum();
		
		Toy result = findBySn(sn);
		
			if (result != null) {
				System.out.println("\n"+result.toString());
				purchaseToy(result);
				
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
	 * Compares input with Toy names in text file
	 * @param toyName accepts string
	 * @return a list of toy objects that contain desired name
	 * */
	private ArrayList<Toy> findByName(String toyName) {
		ArrayList<Toy> matches = new ArrayList<>();
		
		for (Toy toy : toys) {
			if (toy.getName().toLowerCase().contains(toyName.toLowerCase())) {
				matches.add(toy);
			}
		}
		
		return matches;
		
	}
	
	/**
	 * Compares input to Toy Category names
	 * @param toyType accepts desired category
	 * @return a list of toy objects with the matching category name
	 * */
	private ArrayList<Toy> findByCategory(String toyType) {
		ArrayList<Toy> matches = new ArrayList<>();
		
		for (Toy toy : toys) {
			if (toy.getCategory().equalsIgnoreCase(toyType)) {
				matches.add(toy);
			}
		}
		
		return matches;
		
	}

	/**
	 * Prompts user if they want to purchase searched toy. If 'y' is entered, searched toy is removed from toys database
	 *@param accepts a Toy object
	 * */
	private void purchaseToy(Toy t) {
		char option = menu.promptAreYouSure();
		
		if (option == 'y') {
			updateInventory(t);
			menu.promptContinue();
		} else if (option == 'n') {
			menu.promptContinue();
		} 
	}

	//add javadoc comments
	private int updateInventory(Toy toy) {
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
					else {
						BoardGame boardGame = new BoardGame(splitLine[0], splitLine[1], splitLine[2], splitLine[3], Integer.parseInt(splitLine[4]), splitLine[5], splitLine[6], splitLine[7]);
						toys.add(boardGame);
					}
				}
				fileReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found. Try checking your file path");
			}
			
		}
		
	
	}
	

}
