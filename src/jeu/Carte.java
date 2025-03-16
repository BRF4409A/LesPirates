package jeu;

import afficheur.Afficheur;
import afficheur.Iafficheur;

abstract class Carte {
	protected String nom;
	protected String type;
	protected String description;
	
	protected static Iafficheur afficheur = new Afficheur();

	protected Carte(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}
	
	public String getNom() {
		return nom;
	}

	protected abstract String getType();
	
	public String getDescription() {
		return description;
	}
	
	protected abstract void afficherCarte();
	
	protected abstract void actionCarte(Joueur joueur, Joueur adversaire, int index);
}
