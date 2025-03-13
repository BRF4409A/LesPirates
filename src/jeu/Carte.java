package jeu;

import afficheur.Iafficheur;

abstract public class Carte {
	protected String nom;
	protected String type;
	protected String description;
	
	protected static Iafficheur afficheur;

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
	
	/*
	public String[] parserCarte() {
		String[] carte = new String[5];
		carte[0] = nom;
		carte[1] = getType();
		carte[2] = null;
		carte[3] = "0";
		carte[4] = description;

		return carte;
	}
	*/
}
