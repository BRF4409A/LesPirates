package afficheur;

public interface Iafficheur {
	void lancerJeu();
	void introduireJeu();
	void afficherRegles();
	void afficherCarte(String[] carte);
	void afficherPlusieursCartes(String[][] cartes);
	void afficherJoueur(String[] joueur);
	void afficherAllJoueurs(String[][] joueurs);
	String selectionnerNom(int numeroJoueur);
	void piocherCarte(String[] carte, String nomJoueur);
	void piocherMain(String[][] main, String nomJoueur);
	int selectionnerCarte();
	void debuterTour(String nom, int nbTour);
	void afficherGagnant(String nom);
	void jouerCarte(String[] carte, String nom);
}
