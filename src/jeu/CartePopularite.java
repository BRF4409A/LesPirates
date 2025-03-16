package jeu;

public class CartePopularite extends Carte{
	private int popularite;

	public CartePopularite(String nom, int popularite, String description) {
		super(nom, description);
		this.popularite = popularite;
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCartePopularite(nom, getType(), popularite, description);
	}
	
	@Override
	public String getType() {
		return "population";
	}
	
	@Override
	public void actionCarte(Joueur joueur, Joueur adversaire, int index) {
		joueur.modifPopularite(popularite);
	}
	
}
