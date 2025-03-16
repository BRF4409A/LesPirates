package jeu;

import afficheur.Iafficheur;

public class Jeu {
	private String nom;
	private Pioche pioche = new Pioche();
	private static Iafficheur afficheur;
	private Joueur joueur;
	private Joueur adversaire;
	private int nbTour = 0;

	public Jeu (String nom) {
		this.nom = nom;
		joueur = new Joueur("Jack le Borgne", 3, 0);
		adversaire = new Joueur("Bill Jambe-de-Bois", 3, 0);
	}
	
	public static Iafficheur getAfficheur() {
		return afficheur;
	}

	public static void setAfficheur(Iafficheur afficheur) {
		Jeu.afficheur = afficheur;
	}
	
	public void lancerJeu() {
		initialiser();
		joueur = jouerPartie();
		afficheur.afficherGagnant(joueur.getNom());
	}
	
	private void initialiser() {
		afficheur.lancerJeu(nom);
		afficheur.introduireJeu();
		afficheur.afficherRegles();
		pioche.melangerPioche();
		afficheur.afficherJoueur(joueur.getNom(), joueur.getVie(), joueur.getPopularite());
		afficheur.afficherJoueur(adversaire.getNom(), adversaire.getVie(), adversaire.getPopularite());
		joueur.piocherMain(pioche);
		adversaire.piocherMain(pioche);
	}
	
	private int realiserTour(int idCarteJouee) {
		nbTour++;
		afficheur.debuterTour(joueur.getNom(), nbTour);
		joueur.piocherCarte(pioche, idCarteJouee);
		afficheur.afficherMain();
		joueur.afficherMain();
		idCarteJouee = afficheur.selectionnerCarte();
		afficheur.jouerCarte(joueur.getNom(), idCarteJouee);
		joueur.jouerCarte(idCarteJouee, adversaire);
		afficheur.afficherJoueur(joueur.getNom(), joueur.getVie(), joueur.getPopularite());
		afficheur.afficherJoueur(adversaire.getNom(), adversaire.getVie(), adversaire.getPopularite());
		return idCarteJouee;
	}
	
	private Joueur jouerPartie() {
		int idJoueur1 = 4;
		int idJoueur2 = 4;
		boolean unJoueur = true;
		Joueur joueurTemp;
		do{
			if (unJoueur) {
				unJoueur = false;
				idJoueur1 = realiserTour(idJoueur1);
			}else {
				unJoueur = true;
				idJoueur2 = realiserTour(idJoueur2);
			}
			
			joueurTemp = joueur;
			joueur = adversaire;
			adversaire = joueurTemp;
			
		}while(!joueur.verifierVictoire(joueur));
		return joueur;
	}
}
