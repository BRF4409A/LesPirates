package jeu;

public class CarteDiffamation extends Carte{
	private int popularite;
	
	public CarteDiffamation(String nom, int popularite, String description) {
		super(nom, description);
		this.popularite = popularite;
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCartePopularite(nom, getType(), popularite, description);
	}
	
	@Override
	public String getType() {
		return "diffamation";
	}
}