package jeu;

public class Joueur {
	public String nom;
	public int vie;
	public int popularite;
	public Carte[] main = new Carte[5];
	
	
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
	
	public String[] parserCarte(int numCarte) {

		return main[numCarte].parserCarte();
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
		Carte carte = pioche[index];
		return carte;
	}
	
	public void piocherMain(Carte[] pioche, int index) {
		main[0] = piocherCarte(pioche, index);
		main[1] = piocherCarte(pioche, index+1);
		main[2] = piocherCarte(pioche, index+2);
		main[3] = piocherCarte(pioche, index+3);
	}
	
	
}
