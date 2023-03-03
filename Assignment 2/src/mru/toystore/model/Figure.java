package mru.toystore.model;

public class Figure extends Toy {

	
	private String classification;
	private String category;
	

	public Figure(String serialNumber, String name, String brand, String price, int availibility, String ageRating, String classification) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		this.classification = classification;
		
		super.setCategory("Figure");
		
		
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
		return "Category: " + this.getCategory() + super.toString() + ", Classification: " + classification;
	}
	

}
