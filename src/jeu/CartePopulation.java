package jeu;

public class CartePopulation extends Carte{
	private int population;

	public CartePopulation(String nom,int vie, int population, String description) {
		super(nom, vie, description);
		this.population = population;
	}
	
	public String getType() {
		return "population";
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
