package mru.toystore.view;

import java.util.Scanner;

import mru.toystore.exceptions.NegativeValueException;

/**
 * Displays prompts related to Adding a new toy
 * */
public class AddNewToyMenu {

	private Scanner input;
	private StoreMenu storeMenu;
	
	public AddNewToyMenu() {
		input = new Scanner(System.in);
		storeMenu = new StoreMenu();
	}
	
	public void showAddedToyMsg() {
		System.out.println("\nNew Toy Added!\n");
	}
	
	/**
	 * Asks user to enter their desired brand name
	 * @return user's entered name
	 * */
	public String promptBrandName() {
		System.out.print("\nEnter a brand name: ");
		String brand = input.nextLine().trim();
		
		return brand;
	}
	/**
	 * Asks user to enter their desired price
	 * @return user's entered price as a String
	 * */
	public String promptPrice() {
		System.out.print("\nEnter a price: ");
		String price = input.nextLine().trim();
		boolean flag = true;
		while(flag) {
			if (!price.matches("^[0-9]+(?:\\.[0-9]+)?$")) {
				storeMenu.showErrMsg();
				System.out.print("\nEnter a price: ");
				price = input.nextLine().trim();
			} else {
				flag = false;
			}	
		}
		return price;
	}
	
	/**
	 * Asks user to enter their toy's inventory
	 * @return user's entered inventory as a String
	 * */
	public String promptInventory() {
		System.out.print("\nEnter the amount of inventory for this toy: ");
		String inventory = input.nextLine();
		boolean flag = true;
		
		while(flag) {
			if (!inventory.matches("[1-9]+")) {
				System.out.println("\nInventory must contain only non-negative non-zero digits. Please try again.");
				System.out.print("\nEnter the amount of inventory for this toy: ");
				inventory = input.nextLine();
			}else {
				flag = false;
			}
		}
		return inventory;
		
	}
	/**
	 * Asks user to enter the age range for their toy
	 * @return user's entered age as a string;
	 * */
	public String promptAgeRating() {
		System.out.print("\nEnter the minimum age for this game: ");
		String age = input.nextLine();
		boolean flag = true;
		
		while(flag) {
			if (!age.matches("[1-9]+")) {
				System.out.println("\nAge must contain only non-negative, non-zero digits. Please try again.");
				System.out.print("\nEnter the minimum age for this toy: ");
				age = input.nextLine();
			}else {
				flag = false;
			}
		}
		return age;
	}
	
	/**
	 * Asks user what type of classification they want
	 * @return user's selection as a char
	 * */
	public char promptClassifaction() {
		System.out.println("\nSelect a classification:\n");
		System.out.println("\t(A) Action");
		System.out.println("\t(D) Doll");
		System.out.println("\t(H) Historic");
		System.out.print("\nEnter option here: ");
		
		char classification = input.nextLine().toUpperCase().charAt(0);
		boolean flag = true;
		
		while(flag) {
			if(classification != 'A' && classification != 'D' && classification != 'H') {
				storeMenu.showErrMsg();
				System.out.println("\nSelect a classification:\n");
				System.out.println("\t(A) Action");
				System.out.println("\t(D) Doll");
				System.out.println("\t(H) Historic");
				System.out.print("\nEnter option here: ");
				classification = input.nextLine().toUpperCase().charAt(0);	
			}
			else { 
				flag = false;
			}
		}
		
		return classification;
	}
	
	/**
	 * Asks user what material they want for their animal
	 * @return the user's input 
	 * */
	public String promptMaterial() {
		System.out.print("\nEnter the kind of material you want: ");
		String material = input.nextLine().trim();
		boolean flag = true;
		
		while(flag) {
			if(!material.matches("[a-zA-z]+")) {
				storeMenu.showErrMsg();
				System.out.print("\nEnter the kind of material you want: ");
				material = input.nextLine();
			} else {
				flag = false;
			}
		}
		
		return material;
	}
	
	/**
	 * Asks the user what a size they would they like for their animal
	 * @return the user's input as a char
	 * */
	public char promptSize() {
		System.out.println("\nSelect a size:\n");
		System.out.println("\t(S) Small");
		System.out.println("\t(M) Medium");
		System.out.println("\t(L) Large");
		System.out.print("\nEnter option here: ");
		
		char size = input.nextLine().toUpperCase().charAt(0);
		boolean flag = true;
		
		while(flag) {
			//Continue to prop user to select a size if they enter something outside
			//the list of sizes
			if(size != 'S' && size != 'M'&& size != 'L') {
				storeMenu.showErrMsg();
				System.out.println("\nSelect a size:\n");
				System.out.println("\t(S) Small");
				System.out.println("\t(M) Medium");
				System.out.println("\t(L) Large");
				System.out.print("\nEnter option here: ");
				
				size = input.nextLine().toUpperCase().charAt(0);	
			}
			else {
				flag = false;
			}
		}
		return size;
	}
	/**
	 * Asks the user what a type they would they like for their puzzle
	 * @return the user's input as a char
	 * */
	public char promptPuzzleType() {
		System.out.print("\nSelect a puzzle-type:\n");
		System.out.println("\t(M) Mechanical");
		System.out.println("\t(C) Cryptic");
		System.out.println("\t(L) Logic");
		System.out.println("\t(T) Trivia");
		System.out.println("\t(R) Riddle");
		System.out.print("\nEnter option here: ");
		
		char puzzleType = input.nextLine().toUpperCase().charAt(0);
		boolean flag = true;
		
		while(flag) {
			//Continue to prop user to select a type if they enter something outside
			//the list of puzzle types
			if(puzzleType != 'M' && puzzleType != 'C' && puzzleType != 'L' && puzzleType != 'T' && puzzleType != 'R') {
				storeMenu.showErrMsg();
				System.out.print("\nSelect a puzzle-type:\n");
				System.out.println("\t(M) Mechanical");
				System.out.println("\t(C) Cryptic");
				System.out.println("\t(L) Logic");
				System.out.println("\t(T) Trivia");
				System.out.println("\t(R) Riddle");
				System.out.print("\nEnter option here: ");
				puzzleType = input.nextLine().toUpperCase().charAt(0);
			} else {
				flag = false;
			}
		}
		
		return puzzleType;
	}
	/**
	 * Asks the user for the minimum number of players for a board game
	 * @return user's input as a String
	 * */
	public String promptMinNumofPlayers() {
		System.out.print("\nEnter a MINimum number of players: ");
		String players = input.nextLine();
		
		boolean flag = true;
		
		while(flag) {
			//Checks input to make sure only numbers greater than 0 are entered
			if(!players.matches("[1-9]+")) {
				System.out.print("\nInventory must contain only non-negative non-zero digits. Please try again.");
				System.out.print("\nEnter a MINimum number of players: ");
				players = input.nextLine();
			} else {
				flag = false;
			}
		}
		return players;
	
	}
	/**
	 * Asks the user for the maximum number of players for a board game
	 * @return user's input as a String
	 * */
	public String promptMaxNumofPlayers() {
		System.out.print("\nEnter a MAXimum number of players: ");
		String players = input.nextLine();
		
		boolean flag = true;
		
		while(flag) {
			//Checks input to make sure only numbers greater than 0 are entered
			if(!players.matches("[1-9]+")) {
				System.out.print("\nInventory must contain only non-negative non-zero digits. Please try again.");
				System.out.print("\nEnter a MAXimum number of players: ");
				players = input.nextLine();
			} else {
				flag = false;
			}
		}
		return players;
	}
	/**
	 * Asks users to enter designers for board game
	 * @return users input as a String
	 * */
	public String promptDesigners() {
		System.out.print("\nEnter a designer (please seperate using commas if there is more than one designer: ");
		String designers = input.nextLine();
		
		
		return designers;
	}
	
	

	
}
