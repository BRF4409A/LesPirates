package jeu;

import afficheur.Afficheur;
import afficheur.Iafficheur;
import jeu.Joueur;

public class Jeu {
	public String nom;
	public Carte[] pioche = new Carte[97];
	public int idexPioche = 0;
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
		introduire();
		initialiser();
	}
	
	private void introduire() {
		afficheur.lancerJeu();
		afficheur.introduireJeu();
		afficheur.afficherRegles();
		generatePioche();
		afficheur.afficherJoueur(joueur1.parserJoueur());
		afficheur.afficherJoueur(joueur2.parserJoueur());
	}
	
	private void initialiser() {
		joueur1.piocherMain(pioche, idexPioche);
		idexPioche = idexPioche + 4;
		afficheur.afficherCarte(joueur1.parserCarte(0));
		afficheur.afficherCarte(joueur1.parserCarte(1));
		afficheur.afficherCarte(joueur1.parserCarte(2));
		afficheur.afficherCarte(joueur1.parserCarte(3));
		joueur2.piocherMain(pioche, idexPioche);
		idexPioche = idexPioche + 4;
		afficheur.afficherCarte(joueur2.parserCarte(0));
		afficheur.afficherCarte(joueur2.parserCarte(1));
		afficheur.afficherCarte(joueur2.parserCarte(2));
		afficheur.afficherCarte(joueur2.parserCarte(3));
	}
	
	private void generatePioche() {
		
		//TODO
		
		String[] carte0 = new String[5];
		carte0[0] = "ATTAQUE SURPRISE";
		carte0[1] = "attaque";
		carte0[2] = "1";
		carte0[3] = "0";
		carte0[4] = "retire 1 point de vie � l'adversaire";
		String[] carte1 = new String[5];
		carte1[0] = "�P�E ARDENTE";
		carte1[1] = "attaque";
		carte1[2] = "2";
		carte1[3] = "0";
		carte1[4] = "retire 2 points de vie � l'adversaire";
		String[] carte2 = new String[5];
		carte2[0] = "COUP DE CROCHET";
		carte2[1] = "attaque";
		carte2[2] = "3";
		carte2[3] = "0";
		carte2[4] = "retire 3 points de vie � l'adversaire";
		String[] carte3 = new String[5];
		carte3[0] = "COUP DE BOUTEILLE";
		carte3[1] = "attaque";
		carte3[2] = "2";
		carte3[3] = "0";
		carte3[4] = "retire 2 points de vie � l'adversaire";
		String[] carte4 = new String[5];
		carte4[0] = "LANCER DE DAGUE";
		carte4[1] = "attaque";
		carte4[2] = "1";
		carte4[3] = "0";
		carte4[4] = "retire 1 point de vie � l'adversaire";
		String[] carte5 = new String[5];
		carte5[0] = "PROVOCATION BRUTALE";
		carte5[1] = "attaque";
		carte5[2] = "2";
		carte5[3] = "0";
		carte5[4] = "retire 2 points de vie � l'adversaire";
		String[] carte6 = new String[5];
		carte6[0] = "D�FI SANGLANT";
		carte6[1] = "attaque";
		carte6[2] = "3";
		carte6[3] = "0";
		carte6[4] = "retire 3 points de vie � l'adversaire";

		String[] carte7 = new String[5];
		carte7[0] = "DISCOURS SINC�RE";
		carte7[1] = "popularit�";
		carte7[2] = "0";
		carte7[3] = "2";
		carte7[4] = "ajoute 2 points de popularit� � l'utilisateur";
		String[] carte8 = new String[5];
		carte8[0] = "DISCOURS BRUTAL";
		carte8[1] = "popularit�";
		carte8[2] = "-1";
		carte8[3] = "3";
		carte8[4] = "ajoute 3 points de popularit� � l'utilisateur mais lui retire 1 point de vie";
		String[] carte9 = new String[5];
		carte9[0] = "CHANT DE PIRATE";
		carte9[1] = "popularit�";
		carte9[2] = "0";
		carte9[3] = "2";
		carte9[4] = "ajoute 2 points de popularit� � l'utilisateur";
		String[] carte10 = new String[5];
		carte10[0] = "TRAHISON MALICIEUSE";
		carte10[1] = "popularit�";
		carte10[2] = "-2";
		carte10[3] = "4";
		carte10[4] = "ajoute 4 points de popularit� � l'utilisateur mais lui retire 2 points de vie";
		String[] carte11 = new String[5];
		carte11[0] = "SERMENT DE FRATERNITE";
		carte11[1] = "popularit�";
		carte11[2] = "0";
		carte11[3] = "3";
		carte11[4] = "ajoute 3 points de popularit� � l'utilisateur";
		String[] carte12 = new String[5];
		carte12[0] = "DISCOURS ENFLAMM�";
		carte12[1] = "popularit�";
		carte12[2] = "0";
		carte12[3] = "2";
		carte12[4] = "ajoute 2 points de popularit� � l'utilisateur";
	}
}
