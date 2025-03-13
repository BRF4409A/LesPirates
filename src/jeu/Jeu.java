package jeu;

import afficheur.Iafficheur;
import jeu.Joueur;

public class Jeu {
	public String nom;
	public Pioche pioche = new Pioche();
	private static Iafficheur afficheur;
	
	Joueur joueur1;
	Joueur joueur2;

	public Jeu (String nom) {
		this.nom = nom;
		joueur1 = new Joueur("Jack le Borgne", 5, 0);
		joueur2 = new Joueur("Bill Jambe-de-Bois", 5, 0);
	}
	
	public static Iafficheur getAfficheur() {
		return afficheur;
	}

	public static void setAfficheur(Iafficheur afficheur) {
		Jeu.afficheur = afficheur;
	}
	
	public void lancerJeu() {
		initialiser();
	}
	
	private void initialiser() {
		afficheur.lancerJeu();
		afficheur.introduireJeu();
		afficheur.afficherRegles();
		pioche.melangerPioche();
		afficheur.afficherJoueur(joueur1.getNom(), joueur1.getVie(), joueur1.getPopularite());
		afficheur.afficherJoueur(joueur2.getNom(), joueur2.getVie(), joueur2.getPopularite());
		joueur1.piocherMain(pioche);
		afficheur.piocherCarte(joueur2.getNom());
		joueur2.piocherMain(pioche);
	}
	
	private void demarrerTour() {
		joueur1.piocherCarte(pioche);
	}
}
