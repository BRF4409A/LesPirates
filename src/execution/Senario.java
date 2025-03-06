package execution;

import afficheur.Afficheur;
import jeu.Jeu;

public class Senario {
	public static void main(String[] args) {
		Jeu.setAfficheur(new Afficheur());
		Jeu jeu = new Jeu("Les Pirates");
		jeu.lancerJeu();
	}
}
