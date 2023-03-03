package mru.toystore.model;

public class Animal extends Toy {
	
	private String material;
	private String size;

	public Animal(String serialNumber, String name, String brand, String price, int availibility,
			String ageRating, String material, String size) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
		
		this.material = material;
		this.size = size;
		super.setCategory("Animal");
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}

	public String toString() {
		return "Category: "+ this.getCategory() + super.toString() + ", Materials: " + material + ", Size: " + size;
	}
	
}
