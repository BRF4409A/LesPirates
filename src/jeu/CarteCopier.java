package jeu;

public class CarteCopier extends Carte {
	
	public CarteCopier(String nom, String description) {
		super(nom, description);
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCarteCopie(nom, getType(), description);
	}
	
	@Override
	public String getType() {
		return "copie";
	}
	
	@Override
	public void actionCarte(Joueur joueur, Joueur adversaire, int index) {
		int idCarte;
		Carte carteAdversaire;
		afficheur.voirMainAdversaire();
		adversaire.afficherMain();
		idCarte = afficheur.selectionnerCarte();
		carteAdversaire = adversaire.getCarte(idCarte);
		afficheur.jouerCarte(adversaire.getNom(), idCarte);
		joueur.echangerCarte(index, carteAdversaire);
		joueur.jouerCarte(index, adversaire);
	}
}