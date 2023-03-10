package mru.toystore.model;

import java.util.Scanner;

public class NewToy extends Toy{
	
	private String brand;
	private Scanner input;
	
	public NewToy(String serialNumber, String name, String brand, String price, int availibility, String ageRating) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
		
		this.brand = brand;
		input = new Scanner(System.in);
	}

	public void setNewBrand(String brand) {
		System.out.print("Enter a brand name: ");
		this.brand = input.nextLine();
	}
	

	//public
}
