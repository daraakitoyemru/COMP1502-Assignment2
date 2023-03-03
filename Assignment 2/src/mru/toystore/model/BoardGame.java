package mru.toystore.model;

import java.util.ArrayList;

public class BoardGame extends Toy {
	
	private String numOfPlayers;
	private ArrayList<String> designers;

	public BoardGame(String serialNumber, String name, String brand, String price, int availibility,
			String ageRating, String numOfPlayers) {
		super(serialNumber, name, brand, price, availibility, ageRating);
		// TODO Auto-generated constructor stub
		this.numOfPlayers = numOfPlayers;
	}

	public String getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(String numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public ArrayList<String> getDesigners() {
		return designers;
	}

	public void setDesigners(ArrayList<String> designers) {
		this.designers = designers;
	}

}
