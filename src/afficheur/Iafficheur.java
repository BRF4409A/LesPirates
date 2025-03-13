package afficheur;

public interface Iafficheur {
	void lancerJeu();
	void introduireJeu();
	void afficherRegles();
	void afficherCarteVie(String nom, String type, int vie, String description);
	void afficherCartePopularite(String nom, String type, int popularite, String description);
	void afficherJoueur(String nom, int vie, int popularite);
	String selectionnerNom(int numeroJoueur);
	void piocherCarte(String nomJoueur);
	void piocherMain(String nomJoueur);
	int selectionnerCarte();
	void debuterTour(String nom, int nbTour);
	void afficherGagnant(String nom);
	void jouerCarte(String nomJoueur);
}
