package jeu;

import afficheur.Iafficheur;
import afficheur.Afficheur;
public class Joueur {
	private String nom;
	private int vie;
	private int popularite;
	private Carte[] main = new Carte[5];
	
	private static Iafficheur afficheur = new Afficheur();
	
	
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
	
	public Carte getCarte(int index) {
		return main[index];
	}
	
	public void modifPopularite(int modif) {
		popularite = popularite + modif;
		if (popularite>5) {popularite = 5;}
		else if(popularite<0) {popularite = 0;}
	}
	
	public void modifVie(int modif) {
		vie = vie + modif;
		if (vie<0) {vie = 0;}
		else if(vie>3) {vie = 3;}
	}
	
	public void piocherCarte(Pioche pioche, int index) {
		main[index] = pioche.piocherCarte();
		afficheur.piocherCarte(nom);
		main[index].afficherCarte();
	}
	
	public void afficherCarte(int index) {
		main[index].afficherCarte();
	}
	
	public void afficherMain() {
		main[0].afficherCarte();
		main[1].afficherCarte();
		main[2].afficherCarte();
		main[3].afficherCarte();
		main[4].afficherCarte();
	}
	
	public void piocherMain(Pioche pioche) {
		main[0] = pioche.piocherCarte();
		main[1] = pioche.piocherCarte();
		main[2] = pioche.piocherCarte();
		main[3] = pioche.piocherCarte();
		
		afficheur.piocherMain(nom);
		main[0].afficherCarte();
		main[1].afficherCarte();
		main[2].afficherCarte();
		main[3].afficherCarte();
	}
	
	public void jouerCarte(int index, Joueur adversaire) {
		main[index].actionCarte(this, adversaire, index);
	}
	
	public boolean verifierVictoire(Joueur adversaire) {
		return (adversaire.getVie()<=0)||(popularite>=5);
	}
	
	public void echangerCarte(int index, Carte carte) {
		main[index] = carte;
	}
}
