package afficheur;

import java.util.Scanner;

public class Afficheur implements Iafficheur{

	private Scanner scan = new Scanner(System.in);
	private static int NB_CARTE_MAIN = 4;
	private static int NB_JOUEUR_MAX = 2;
	
	@Override
	public void lancerJeu() {
		System.out.println("Début du jeu sur « Les Pirates » !\n\n");
	}
	
	@Override
	public void introduireJeu() {
		System.out.println("Jack le Borgne et Bill Jambe-de-Bois sont deux pirates souhaitant prendre le \n"
				+ "commandement du navire à l’etendard noir, « Le Sanguinaire ». L’equipage doit donc les \n"
				+ "departager par un vote. Chacun des deux rivaux doit ainsi gagner en popularite (ou \n"
				+ "affaiblir son adversaire) afin de devenir le nouveau capitaine. \n");
	}
	
	@Override
	public void afficherRegles() {
		System.out.println(
				"Le Jeu des Pirates est un jeu de societe de cartes dans lequel deux joueurs \n" + "s’affrontent. \n"
						+ "-Chaque joueur pioche quatre cartes. A tour de role, un pirate pioche une nouvelle \n"
						+ "carte et l’ajoute à sa main. Il doit ensuite decider s’il attaque son adversaire ou s’il \n"
						+ "s’attribue des points de popularite. \n"
						+ "-Chaque pirate possede cinq cœurs rouges correspondant a ses points de vie. S’il n’a \n"
						+ "plus de coeur, alors il a perdu et son adversaire gagne. \n"
						+ "-Le but du jeu est que son pirate atteigne cinq points de popularite ou simplement \n"
						+ "survive plus longtemps que son adversaire ! \n"
						+ "-Au debut de son tour, le pirate pioche une carte et l’ajoute à sa main. \n"
						+ "Il choisit ensuite parmi sa main, composee de cinq cartes, une carte qu’il depose : \n"
						+ "\t -Dans sa zone de popularite s’il s’agit d’une carte de popularite, \n"
						+ "\t -Dans la zone de son adversaire s’il s’agit d’une carte d’attaque. \n\n\n"
						+ "Voici les deux joueurs : \n");
	}
	
	@Override
	public void afficherCarteVie(String nom, String type, int vie, String description) {
		StringBuilder chaine = new StringBuilder("\t Carte : " + nom + " (" + type + ")" + "\n");
		chaine.append("\t vie : " + vie + "\n");
		chaine.append("\t description : " + description + "\n\n");
		System.out.println(chaine);
	}
	
	@Override
	public void afficherCartePopularite(String nom, String type, int popularite, String description) {
		StringBuilder chaine = new StringBuilder("\t Carte : " + nom + " (" + type + ")" + "\n");
		chaine.append("\t popularité : " + popularite + "\n");
		chaine.append("\t description : " + description + "\n\n");
		System.out.println(chaine);
	}
	
	/*
	@Override
	public void afficherPlusieursCartes(String[][] cartes) {
		System.out.println("---------------------\n");
		System.out.println("CARTES EN MAIN : \n");
		for (int i = 0; i < cartes.length; i++) {
			System.out.println(" \t numero carte : " + (i + 1) + "\n");
			afficherCarte(cartes[i]);
		}
		System.out.println("---------------------\n\n");
	}
	*/
	
	@Override
	public void afficherJoueur(String nom, int vie, int popularite) {
		StringBuilder chaine = new StringBuilder(nom + ": \n");
		chaine.append("\t Vie : " + vie + "\n");
		chaine.append("\t Popularité : " + popularite + "\n");
		System.out.println(chaine);
	}
	
	/*
	@Override
	public void afficherAllJoueurs(String[][] joueurs) {
		System.out.println("---------------------\n");
		System.out.println("AFFICHAGE DES JOUEURS : \n");
		for (int i = 0; i < NB_JOUEUR_MAX; i++) {
			afficherJoueur(joueurs[i]);
		}
		System.out.println("---------------------\n\n");
	}
	*/
	
	@Override
	public String selectionnerNom(int numeroJoueur) {
		System.out.print("Selectionnez un joueur" + numeroJoueur + " : ");
		return scan.next();
	}
	
	@Override
	public void piocherCarte(String nomJoueur) {
		System.out.println(nomJoueur + " pioche une carte : \n");
	}
	
	
	@Override
	public void piocherMain(String nomJoueur) {
		System.out.println(nomJoueur + " pioche une main de " + NB_CARTE_MAIN + " cartes \n");
	}
	
	@Override
	public int selectionnerCarte() {
		int numChoix = 0;
		System.out.println("Sélectionnez le numéro de la carte à afficher : ");
		StringBuilder chaine = new StringBuilder("Le choix doit être entre 1 et 5 !");

		do {
			numChoix = Integer.parseInt(scan.next());
			if (!(numChoix > 0 && numChoix < 6))
				System.out.println(chaine);

		} while (!(numChoix > 0 && numChoix < 6));
		return numChoix - 1;
	}
	
	@Override
	public void debuterTour(String nom, int nbTour) {
		System.out.println("--------------Tour : " + nbTour + "--------------\n");
		System.out.println("C'est au tour de " + nom + " de jouer \n");
	}
	
	@Override
	public void afficherGagnant(String nom) {
		System.out.println("Felicitation " + nom + " tu gagnes la partie !!! \n");
	}
	
	@Override
	public void jouerCarte(String nomJoueur) {
		System.out.println(nomJoueur+" joue une carte dans la zone "+" \n");
	}
}

