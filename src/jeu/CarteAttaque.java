package jeu;

public class CarteAttaque extends Carte {
	private static final String TYPE  = "Attaque";
	
	public CarteAttaque(String nom, int vie) {
		super(nom, vie);
	}
	
	@Override
	public String donnerType() {
		return TYPE;
	}
}
