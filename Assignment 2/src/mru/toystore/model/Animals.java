package mru.toystore.model;

public class Animals extends Toy {
	
	private String material;
	private String size;

	public Animals(String serialNumber, String name, String brand, String price, String availibility,
			String ageRating, String material, String size) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
		
		this.material = material;
		this.size = size;
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
		return "Category: Animal, " + super.toString();
	}
	
}
