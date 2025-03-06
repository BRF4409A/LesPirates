package jeu;

public class CarteSoin extends Carte {
	
	public CarteSoin(String nom, int vie, String description) {
		super(nom, vie, description);
	}
	
	public String getType() {
		return "soin";
	}
}
