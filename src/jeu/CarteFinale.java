package jeu;

public class CarteFinale extends CarteAttaque{
	
	public CarteFinale(String nom, int vie, String description) {
		super(nom, vie, description);
	}
	
	public String getType() {
		return "finale";
	}
}
