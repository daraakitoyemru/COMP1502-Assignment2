package mru.toystore.model;

public class BoardGame extends Toy {
	
	private String numOfPlayer;
	private String designers;

	public BoardGame(String serialNumber, String name, String brand, String price, int availibility,
			String ageRating) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
	}

}
