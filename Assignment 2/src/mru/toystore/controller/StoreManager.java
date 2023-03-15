package mru.toystore.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
	
	private final String FILE_PATH  = "res/toys.txt";
	
	public StoreManager() {
		menu = new StoreMenu();
		newToy = new AddNewToy();
		newToyMenu = new AddNewToyMenu();
		toys = new ArrayList<>();
		
		
		menu.showWelcomeBanner();
		loadData();
		launchApp();
		
	}
	
	
	/**
	 * Launches the application and shows the main menu to user
	 *  
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
					break;
				case "3":
					removeToy();
					break;
				case "4":
					System.out.println("\nSaving...");
					Save();
					menu.showThankYou();
					flag = false;
					break;
				default:
					
					menu.showErrMsg();
					
					continue;
				}
		}
	}

	/**
	 * Saves edited toys to txt file
	 * */
	private void Save() {
		File db = new File(FILE_PATH);
		try {
			PrintWriter pw = new PrintWriter(db);
			for (Toy toy: toys) {
				pw.println(toy.format());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	//add doc
	private void removeToy() {
		boolean flag = true;
		
		while(flag) {
			try {
				String sn = newToy.validateSn();
				Toy toy = findBySn(sn);
				
				if(toy != null) {
					System.out.println("\nItem found: \n");
					System.out.println(toy.toString());
					remove(toy);
					flag = false;
				} else {
					System.out.println("\nToy not found");
					menu.promptContinue();
					break;	
				}
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

	
		private void remove(Toy toy) {
		char option = menu.promptRemove();
		
		if (option == 'y') {
			toys.remove(toy);
			System.out.println("\nItem removed!");
			menu.promptContinue();
		} else if (option == 'n') {
			menu.promptContinue();
		}
		
	}


	/**
	 * First, prompts the user to enter a serial number, then checks to see if it is exists.
	 * Then, gives the user a variety of prompts based on what serial number they enter.
	 * */
	private void addNewToy() {
		// TODO Auto-generated method stub
		
		boolean flag = true;
		
		while(flag) {
			try {
				//Checking sn to ensure it is in the right format
				String sn = newToy.validateSn();
				ArrayList<String> newToyData = newToy.toyData(sn);
				//Making sure the sn does not exists before proceeding to avoid duplicate serial numbers
				if (checkSn(sn)) {
					System.out.println("\n This toy already exists. Please try again");
					continue;
				//Creates a toy object based on first digit of serial number
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
				} else {
					BoardGame boardGame = new BoardGame(sn, newToyData.get(0), newToyData.get(1), newToyData.get(2), Integer.parseInt(newToyData.get(3)), newToyData.get(4), newToyData.get(5), newToyData.get(6));
					toys.add(boardGame);
					newToyMenu.showAddedToyMsg();
					menu.promptContinue();
					break;
				}
				
			} catch (InvalidFormatException e) {
				//Displays error message if serial number is enterd correctly
				System.out.println(e.getMessage());
			}
		}
		
	}

	/**
	 * Checks if a entered serial number exists in the database
	 * @param sn is a serial number as a String
	 * @return true is the serial number does exist, false if it doesn't
	 * */
	private boolean checkSn(String sn) {
		for (Toy toy : toys) {
			if (sn.equals(toy.getSerialNumber())) {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * Launches menu for Search and Purchase option and allows navigation
	 * */
	private void Search() {
		
		boolean flag = true;
		
		while (flag) {
				String option = menu.showSubMenu();
				
				switch (option) {
				case "1":
					searchBySerialNum();
					break;
				case "2":
					searchByName();
					break;
				case "3":
					searchByCategory();
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
	
	/**
	 * Asks users for toy type (Puzzle, Figure, Animal, Board Game) and returns a numbered list
	 * of matching results. Users are then asked to purchase their selected option
	 * */
	private void searchByCategory() {
		//Asks user for what kind of toy their looking for
		String toyType = menu.promptCategoryName();
		
		//List containing matching toy objects
		ArrayList<Toy> matches = findByCategory(toyType);
		
		boolean flag = true;
		
		while(flag) {
			//Formats matches into a numbered list, then asks which toy they would want to buy
			if (matches.size() != 0) {
				formatToy(matches);
				String option = menu.promptPurchaseOption();
				//displays selected option to user, asks if they want still want to buy or not
				if (Integer.parseInt(option) <= matches.size() && Integer.parseInt(option) != 0) {
					System.out.println("\nSelected toy: " + matches.get(Integer.parseInt(option) - 1));
					purchaseToy(matches.get(Integer.parseInt(option) - 1));
					flag = false;
				} else {
					//Shows error message if user enters a character that is not in the numbered list
					System.out.println("\n********Please enter a number within range*********\n");
					
					continue;
				}
				
			}
			else {
				//Shows error message if entered toy type does not exist in database
				System.out.println("\nnot found");
				flag = false;
			}
		}
		
	}
	
	/**
	 * Formats list of toys into a numbered list and displays list to console
	 * @param toyList as an ArrayList containing Toy objects
	 * */
	private void formatToy(ArrayList<Toy> toyList) {
		for (int i = 0; i < toyList.size(); i++) {
			System.out.println("("+(i + 1)+")" + " " + toyList.get(i).toString());
		}
		
	}
	
	
	/**
	 * Asks users for toy name and returns a numbered list
	 * of matching results. Users are then asked to purchase their selected option
	 * */
	private void searchByName() {
		//Asks user for toy name
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
	 * Looks for matching sn in database and returns that toy if found.
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

	/**
	 * Checks inventory of toy and decreases if inventory does not equal 0. 
	 * Displays out of stock message if inventory is zero
	 * @param toy is a single Toy object
	 * */
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
	
	
	/**
	 * Reads data from txt file and creates specific toy objects based off serial number
	 * */
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
