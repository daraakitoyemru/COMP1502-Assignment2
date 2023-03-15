package mru.toystore.model;

public class Puzzle extends Toy{
	
	private String puzzleType;
	

	public Puzzle(String serialNumber, String name, String brand, String price, int availibility,
			String ageRating, String puzzleType) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
		this.puzzleType = puzzleType;
		super.setCategory("Puzzle");
	}

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	public String toString() {
		return "Category: " + this.getCategory() + super.toString() + " Puzzle-type: " + puzzleType;
	}

	public String format() {
		return super.format()+";"+ this.getPuzzleType();
	}
}
