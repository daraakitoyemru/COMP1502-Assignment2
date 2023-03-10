package mru.toystore.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StoreMenu {
	
	
	private Scanner input;
	
	public StoreMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * Displays welcome banner to console
	 * */
	public void showWelcomeBanner() {
		System.out.println("**************************************************");
		System.out.println("*          WELCOME TO OUR TOY STORE              *");
		System.out.println("**************************************************");

	}
	
	/**
	 * Displays Thank You banner to console
	 * */
	public void showThankYou() {
		System.out.println("\n**************** THANKS FOR VISITING *************");
	}
	
	public void showErrMsg() {
		System.out.println("\n**************** INVALID INPUT: Please try again *************\n");
	}
	/**
	 * Display main menu to console
	 * @return returns user's entered option
	 * */
	public String showMainMenu() {
		System.out.println("\nHow can we help you?\n");
		System.out.println("(1)\tSearch Inventory and Purchase Toy");
		System.out.println("(2)\tAdd New Toy");
		System.out.println("(3)\tRemove Toy");
		System.out.println("(4)\tSave & Exit");
		System.out.print("\nEnter an option: ");
		
		String option = input.nextLine().trim();
//		int option = input.nextInt();
//		input.nextLine();
		
		return option;
	}
	
	
	/**
	 * Display sub menu to console
	 * @return returns user's entered option
	 * */
	public String showSubMenu() {
		System.out.println("\nSearch Toy By:\n");
		System.out.println("(1)\tSerial Number (SN)");
		System.out.println("(2)\tToy Name");
		System.out.println("(3)\tCategory");
		System.out.println("(4)\tBack to Main Menu");
		System.out.print("\nEnter an option: ");
		
		String option = input.nextLine().trim();
//		int option = input.nextInt();
//		input.nextLine();
		
		return option;
	}
	
	/**
	 * Prompts user for toy serial number
	 * @return returns users input as integer number
	 * */
	public String promptSerialNum() {
		//add exception handling
		System.out.print("\nEnter serial number: ");
		String serialNum = input.nextLine();
		
		
		return serialNum;
	}
	
	public String promptPrice() {
		System.out.print("\nEnter desired price: ");
		String price = input.nextLine();
		return price;
	}
	
	//add javadoc
	public String promptToyName() {
		System.out.print("\nEnter toy name: ");
		String toyName = input.nextLine().trim();
		
		return toyName;

	}
	
	//add javadoc
	public String promptCategoryName() {
		System.out.print("\nEnter toy type: ");
		String toyType = input.nextLine();
		
		return toyType;

	}
	
	public String promptPurchaseOption() {
		System.out.print("\nEnter the number of the toy you'd like to buy: ");
		String option = input.nextLine();
		boolean flag = true;
		
		while(flag) {
			if (!option.matches("[0-9]+")) {
				showErrMsg();
				System.out.print("\nEnter the number of the toy you'd like to buy: ");
				option = input.nextLine();
			} else {
				flag = false;
			}
		}
		
		return option;
	}
	
	//add javadoc
	public char promptAreYouSure() {
		System.out.print("\nAre you sure you want to purchase? (Y/N) ");
		char option = input.nextLine().toLowerCase().charAt(0);
		boolean flag = true;
		
		while (flag) {
			if (option != 'y' && option != 'n') {
				showErrMsg();
				System.out.print("\nAre you sure you want to purchase? (Y/N) ");
				option = input.nextLine().toLowerCase().charAt(0);
			} else {
				flag = false;
			}
		}
		
		return option;
	}
	
	//add javadoc
	public void promptContinue() {
		System.out.print("\nPress Enter to continue: ");
		String keyboard = input.nextLine();
		
		boolean flag = true;
		
		while (flag) {
			if (keyboard.equals("")) {
				flag = false;
			} else {
				System.out.print("\nPress Enter to continue: ");
				keyboard = input.nextLine();
			}
		}
		
	}
}
