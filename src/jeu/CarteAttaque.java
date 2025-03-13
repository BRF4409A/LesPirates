package jeu;

public class CarteAttaque extends Carte {
	private int vie;
	
	public CarteAttaque(String nom, int vie, String description) {
		super(nom, description);
		this.vie = vie;
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCarteVie(nom, getType(), vie, description);
	}
	
	@Override
	public String getType() {
		return "attaque";
	}
}
