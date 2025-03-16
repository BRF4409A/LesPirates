package jeu;

public class CarteSoin extends Carte {
	private int vie;
	
	public CarteSoin(String nom, int vie, String description) {
		super(nom, description);
		this.vie = vie;
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCarteVie(nom, getType(), vie, description);
	}
	
	@Override
	public String getType() {
		return "soin";
	}
	
	@Override
	public void actionCarte(Joueur joueur, Joueur adversaire, int index) {
		joueur.modifVie(vie);
	}
}
