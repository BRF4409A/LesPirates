package jeu;

public abstract class Carte {
	protected int vie;
	protected String nom;
	
	protected Carte (String nom, int vie) {
		this.nom = nom;
		this.vie = vie;
	}
	
	protected abstract String donnerType();
}
