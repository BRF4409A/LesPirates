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
	
	public String getNom() {
		return nom;
	}
	public int getVie() {
		return vie;
	}
	public int getPopularite() {
		return popularite;
	}
	
	public Carte piocherCarte(Pioche pioche) {
		Carte carte = pioche.piocherCarte();
		afficheur.piocherCarte(nom);
		carte.afficherCarte();
		
		return carte;
	}
	
	public void piocherMain(Pioche pioche) {
		main[0] = pioche.piocherCarte();
		main[1] = pioche.piocherCarte();
		main[2] = pioche.piocherCarte();
		main[3] = pioche.piocherCarte();
		
		main[0].afficherCarte();
		main[1].afficherCarte();
		main[2].afficherCarte();
		main[3].afficherCarte();
	}
	
	
}
