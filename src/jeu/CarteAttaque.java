package jeu;

public class CarteAttaque extends Carte {
	
	public CarteAttaque(String nom, int vie, String description) {
		super(nom, vie, description);
	}
	
	public String getType() {
		return "attaque";
	}
}
