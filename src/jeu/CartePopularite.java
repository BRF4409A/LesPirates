package jeu;

public class CartePopularite extends Carte{
	private int population;

	public CartePopularite(String nom, int population, String description) {
		super(nom, description);
		this.population = population;
	}
	
	@Override
	public void afficherCarte() {
		afficheur.afficherCarteVie(nom, getType(), population, description);
	}
	
	@Override
	public String getType() {
		return "population";
	}
	
}
