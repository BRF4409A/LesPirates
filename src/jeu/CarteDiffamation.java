package jeu;

public class CarteDiffamation extends Carte{
	private int population;
	
	public CarteDiffamation(String nom,int vie, int population, String description) {
		super(nom, vie, description);
		this.population = population;
	}
	
	public String getType() {
		return "diffamation";
	}
	
	public String[] parserCarte() {
		String[] carte = new String[5];
		carte[0] = nom;
		carte[1] = getType();
		carte[2] = String.valueOf(vie);
		carte[3] = String.valueOf(population);
		carte[4] = description;
		
		return carte;
	}
}