package jeu;

public class Carte {
	protected String nom;
	protected String type;
	protected String description;
	protected int vie;

	protected Carte(String nom, int vie, String description) {

		this.nom = nom;
		this.description = description;
		this.vie = vie;
	}

	public String getType() {
		return "random";
	}

	// public String getInfo() {

	// protected abstract Carte piocherCarte();

	// protected abstract Carte[] piocherDesCartes(int nbCarte);

	public String[] parserCarte() {
		String[] carte = new String[5];
		carte[0] = nom;
		carte[1] = getType();
		carte[2] = String.valueOf(vie);
		carte[3] = "0";
		carte[4] = description;

		return carte;
	}

	/*
	 * public String[][] parserDesCartes(){
	 * 
	 * String[][] carte = new String[5][5]; carte[0] = nom; carte[1] = type;
	 * carte[2] = String.valueOf(vie); carte[3] = "0"; carte[4] = description;
	 * 
	 * return carte; }
	 */

	// protected abstract Carte choisirCartes(int choix);
}
