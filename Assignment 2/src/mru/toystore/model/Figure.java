package mru.toystore.model;

public class Figure extends Toy {

	
	private String classification;

	public Figure(String serialNumber, String name, String brand, String price, String availibility, String ageRating, String classification) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		this.classification = classification;
	}
	public String getClassification() {
		return classification;
		
	}

	/**
	 * Sets classification type for figure
	 * */
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	/**
	 * Formats information for readability
	 * */
	public String toString() {
		return "Category: Figure, " + super.toString();
	}
	

}
