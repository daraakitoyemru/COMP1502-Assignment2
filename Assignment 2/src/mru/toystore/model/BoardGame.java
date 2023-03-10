package mru.toystore.model;


public class BoardGame extends Toy {
	
	
	private String numOfPlayers;
	private String designers;

	public BoardGame(String serialNumber, String name, String brand, String price, int availibility,
			String ageRating, String numOfPlayers, String designers) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
		this.numOfPlayers = numOfPlayers;
		this.designers = designers;
		super.setCategory("Board Game");
	}



	public String getDesigners() {
		return designers;
	}

	public void setDesigners(String designers) {
		this.designers = designers;
	}


	public String getNumOfPlayers() {
		return numOfPlayers;
	}


	public void setNumOfPlayers(String numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	public String toString() {
		return "Category: "+ this.getCategory() + super.toString() + ", Number of players: " + this.getNumOfPlayers() + ", Designers: " + this.getDesigners();
	}
}
