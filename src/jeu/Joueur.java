package jeu;

import afficheur.Iafficheur;

public class Joueur {
	private String nom;
	private int vie;
	private int popularite;
	private Carte[] main = new Carte[5];
	
	private static Iafficheur afficheur;
	
	
	public Joueur(String nom, int vie, int popularite) {
		this.nom = nom;
		this.vie = vie;
		this.popularite = popularite;
	}
	
	public String[] parserJoueur() {
		String[] joueur = new String[3];
		joueur[0] = nom;
		joueur[1] = String.valueOf(vie);
		joueur[2] = String.valueOf(popularite);

		return joueur;
	}
	
	public String getNom() {
		return nom;
	}
	public int getVie() {
		return vie;
	}
	public int getPopularite() {
		return popularite;
	}
	
	public Carte piocherCarte(Carte[] pioche, int index) {
		pioche[index].afficherCarte();
		return pioche[index];
	}
	
	public void piocherMain(Carte[] pioche, int index) {
		main[0] = piocherCarte(pioche, index);
		main[1] = piocherCarte(pioche, index+1);
		main[2] = piocherCarte(pioche, index+2);
		main[3] = piocherCarte(pioche, index+3);
		
		main[0].afficherCarte();
		main[1].afficherCarte();
		main[2].afficherCarte();
		main[3].afficherCarte();
	}
	
	
}
