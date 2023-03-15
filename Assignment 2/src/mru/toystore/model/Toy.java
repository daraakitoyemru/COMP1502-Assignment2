package mru.toystore.model;

public abstract class Toy {
	
	public String serialNumber;
	private String name;
	private String brand;
	private String price;
	private int availibility;
	private String ageRating;
	private String category;
	
	public Toy(String serialNumber, String name, String brand, String price, int availibility, String ageRating) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availibility = availibility;
		this.ageRating = ageRating;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getAvailibility() {
		return availibility;
	}

	public void setAvailibility(int availibility) {
		this.availibility = availibility;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String toString() {
		return ", Serial Number: " + serialNumber + ", Name: " + name + ", Brand: " + brand + ", Price: " + price + ", Inventory: " +  availibility + ", Age Rating: " + ageRating ; 
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String format() {
		return this.getSerialNumber()+";"+this.getName()+";"+this.getBrand()+";"+this.getPrice()+";"+this.getAvailibility()+";"+this.getAgeRating();
	}

}
