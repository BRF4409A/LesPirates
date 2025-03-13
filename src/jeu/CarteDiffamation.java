package jeu;

public class CarteDiffamation extends Carte{
	private int population;
	
	public CarteDiffamation(String nom, int population, String description) {
		super(nom, description);
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCarteVie(nom, getType(), population, description);
	}
	
	@Override
	public String getType() {
		return "diffamation";
	}
}