package mru.toystore.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import mru.toystore.model.Figure;
import mru.toystore.model.Toy;
import mru.toystore.view.StoreMenu;

public class StoreManager {

	
	private StoreMenu menu;
	private ArrayList<Toy> toys;
	private final String FILE_PATH  = "res/toys.txt";
	
	public StoreManager() {
		menu = new StoreMenu();
		toys = new ArrayList<>();
		
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
					
					flag = false;
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
					
					if (splitLine[0].charAt(0) == '0' || splitLine[0].charAt(0) == '1') {
						Figure figure = new Figure(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5], splitLine[6]);
						toys.add(figure);
					}
					//Come back later
					for (Toy t : toys) {
						System.out.println(((Figure) t).toString());
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
