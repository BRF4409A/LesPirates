package afficheur;

import java.util.Scanner;

public class Afficheur {

	private Scanner scan = new Scanner(System.in);
	private static int NB_CARTE_MAIN = 4;
	private static int NB_JOUEUR_MAX = 2;

	public void lancerJeu() {
		System.out.println("Début du jeu sur « Les Pirates » !\n\n");
	}

	public void introduireJeu() {
		System.out.println("Jack le Borgne et Bill Jambe-de-Bois sont deux pirates souhaitant prendre le \n"
				+ "commandement du navire à l’etendard noir, « Le Sanguinaire ». L’equipage doit donc les \n"
				+ "departager par un vote. Chacun des deux rivaux doit ainsi gagner en popularite (ou \n"
				+ "affaiblir son adversaire) afin de devenir le nouveau capitaine. \n");
	}

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
						+ "\t -Dans la zone de son adversaire s’il s’agit d’une carte d’attaque. \n");
	}

	public void afficherCarte(String[] carte) {
		StringBuilder chaine = new StringBuilder("\t nom : " + carte[0] + " (" + carte[1] + ")" + "\n");
		chaine.append("\t vie : " + carte[2] + "\n");
		chaine.append("\t popularité : " + carte[3] + "\n");
		chaine.append("\t description : " + carte[4] + "\n\n");
		System.out.println(chaine);
	}

	public void afficherPlusieursCartes(String[][] cartes) {
		System.out.println("---------------------\n");
		System.out.println("CARTES EN MAIN : \n");
		for (int i = 0; i < cartes.length; i++) {
			System.out.println(" \t numero carte : " + (i + 1) + "\n");
			afficherCarte(cartes[i]);
		}
		System.out.println("---------------------\n\n");
	}

	public void afficherJoueur(String[] joueur) {
		StringBuilder chaine = new StringBuilder("\t nom : " + joueur[0] + "\n");
		chaine.append("\t vie : " + joueur[1] + "\n");
		chaine.append("\t popularité : " + joueur[2] + "\n");
		System.out.println(chaine);
	}

	public void afficherAllJoueurs(String[][] joueurs) {
		System.out.println("---------------------\n");
		System.out.println("AFFICHAGE DES JOUEURS : \n");
		for (int i = 0; i < NB_JOUEUR_MAX; i++) {
			afficherJoueur(joueurs[i]);
		}
		System.out.println("---------------------\n\n");
	}

	public String selectionnerNom(int numeroJoueur) {
		System.out.print("Selectionnez un joueur" + numeroJoueur + " : ");
		return scan.next();
	}

	public void piocherCarte(String[] carte, String nomJoueur) {
		System.out.println(nomJoueur + " pioche une carte : \n");
		afficherCarte(carte);
	}

	public void piocherMain(String[][] main, String nomJoueur) {
		System.out.println(nomJoueur + " pioche une main de " + NB_CARTE_MAIN + " cartes \n");
		for (int i = 0; i < NB_CARTE_MAIN; i++) {
			piocherCarte(main[i], nomJoueur);
		}
	}

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

	public void debuterTour(String nom, int nbTour) {
		System.out.println("--------------Tour : " + nbTour + "--------------\n");
		System.out.println("C'est au tour de " + nom + " de jouer \n");
	}

	public void afficherGagnant(String nom) {
		System.out.println("Felicitation " + nom + " tu gagnes la partie !!! \n");
	}
	
	public void jouerCarte(String[] carte, String nom, boolean zoneAttaque) {
		String nomZone;
		if (zoneAttaque)
			nomZone = "ATTAQUE";
		else
			nomZone = "POPULARITE";

		System.out.println(nom+" joue une carte dans la zone "+nomZone+" \n");
		afficherCarte(carte);
	}

	public static void main(String[] args) {

		String[] carte0 = new String[5];
		carte0[0] = "ATTAQUE SURPRISE";
		carte0[1] = "attaque";
		carte0[2] = "1";
		carte0[3] = "0";
		carte0[4] = "retire 1 point de vie à l'adversaire";
		String[] carte1 = new String[5];
		carte1[0] = "ÉPÉE ARDENTE";
		carte1[1] = "attaque";
		carte1[2] = "2";
		carte1[3] = "0";
		carte1[4] = "retire 2 points de vie à l'adversaire";
		String[] carte2 = new String[5];
		carte2[0] = "COUP DE CROCHET";
		carte2[1] = "attaque";
		carte2[2] = "3";
		carte2[3] = "0";
		carte2[4] = "retire 3 points de vie à l'adversaire";
		String[] carte3 = new String[5];
		carte3[0] = "COUP DE BOUTEILLE";
		carte3[1] = "attaque";
		carte3[2] = "2";
		carte3[3] = "0";
		carte3[4] = "retire 2 points de vie à l'adversaire";
		String[] carte4 = new String[5];
		carte4[0] = "LANCER DE DAGUE";
		carte4[1] = "attaque";
		carte4[2] = "1";
		carte4[3] = "0";
		carte4[4] = "retire 1 point de vie à l'adversaire";
		String[] carte5 = new String[5];
		carte5[0] = "PROVOCATION BRUTALE";
		carte5[1] = "attaque";
		carte5[2] = "2";
		carte5[3] = "0";
		carte5[4] = "retire 2 points de vie à l'adversaire";
		String[] carte6 = new String[5];
		carte6[0] = "DÉFI SANGLANT";
		carte6[1] = "attaque";
		carte6[2] = "3";
		carte6[3] = "0";
		carte6[4] = "retire 3 points de vie à l'adversaire";

		String[] carte7 = new String[5];
		carte7[0] = "DISCOURS SINCÈRE";
		carte7[1] = "popularité";
		carte7[2] = "0";
		carte7[3] = "2";
		carte7[4] = "ajoute 2 points de popularité à l'utilisateur";
		String[] carte8 = new String[5];
		carte8[0] = "DISCOURS BRUTAL";
		carte8[1] = "popularité";
		carte8[2] = "-1";
		carte8[3] = "3";
		carte8[4] = "ajoute 3 points de popularité à l'utilisateur mais lui retire 1 point de vie";
		String[] carte9 = new String[5];
		carte9[0] = "CHANT DE PIRATE";
		carte9[1] = "popularité";
		carte9[2] = "0";
		carte9[3] = "2";
		carte9[4] = "ajoute 2 points de popularité à l'utilisateur";
		String[] carte10 = new String[5];
		carte10[0] = "TRAHISON MALICIEUSE";
		carte10[1] = "popularité";
		carte10[2] = "-2";
		carte10[3] = "4";
		carte10[4] = "ajoute 4 points de popularité à l'utilisateur mais lui retire 2 points de vie";
		String[] carte11 = new String[5];
		carte11[0] = "SERMENT DE FRATERNITE";
		carte11[1] = "popularité";
		carte11[2] = "0";
		carte11[3] = "3";
		carte11[4] = "ajoute 3 points de popularité à l'utilisateur";
		String[] carte12 = new String[5];
		carte12[0] = "DISCOURS ENFLAMMÉ";
		carte12[1] = "popularité";
		carte12[2] = "0";
		carte12[3] = "2";
		carte12[4] = "ajoute 2 points de popularité à l'utilisateur";
		
		/*
		String[][] data = { { "ATTAQUE SURPRISE", "1", "0", "retire 1 point de vie à l'adversaire" },
				{ "ÉPÉE ARDENTE", "2", "0", "retire 2 points de vie à l'adversaire" },
				{ "COUP DE CROCHET", "3", "0", "retire 3 points de vie à l'adversaire" },
				{ "COUP DE BOUTEILLE", "2", "0", "retire 2 points de vie à l'adversaire" },
				{ "LANCER DE DAGUE", "1", "0", "retire 1 point de vie à l'adversaire" },
				{ "PROVOCATION BRUTALE", "2", "0", "retire 2 points de vie à l'adversaire" },
				{ "DÉFI SANGLANT", "3", "0", "retire 3 points de vie à l'adversaire" },
				{ "DISCOURS SINCERE", "0", "2", "ajoute 2 points de popularité à l'utilisateur" },
				{ "DISCOURS BRUTAL", "-1", "3",
						"ajoute 3 points de popularité à l'utilisateur mais lui retire 1 point de vie" },
				{ "CHANT DE PIRATE", "0", "2", "ajoute 2 points de popularité à l'utilisateur" },
				{ "TRAHISON MALICIEUSE", "-2", "4",
						"ajoute 4 points de popularité à l'utilisateur mais lui retire 2 points de vie" },
				{ "SERMENT DE FRATERNITE", "0", "3", "ajoute 3 points de popularité à l'utilisateur" },
				{ "DISCOURS ENFLAMME", "0", "2", "ajoute 2 points de popularité à l'utilisateur" } };

		
		 int lengthCartes = data.length; String[][] cartes = new
		 String[lengthCartes][4]; for (int i = 0; i < lengthCartes; i++) { for (int j
		 = 0; j < NB_CARTE_MAIN; j++) { cartes[i][j] = data[i][j]; } }
		 
		 String[][] cartes1 = new String[NB_CARTE_MAIN][4]; String[][] cartes2 = new
		 String[NB_CARTE_MAIN][4]; for(int i=0;i<NB_CARTE_MAIN;i++) { for(int
		 j=0;j<4;j++) { cartes1[i][j]=cartes[i][j];
		 cartes2[i][j]=cartes[lengthCartes-1-i][j]; } }
		*/
		
		String nomJoueur1="Jack le Borgne";
		String nomJoueur2="Bill Jambe-de-Bois";
		String[] joueur1 = new String[3];
		joueur1[0]=nomJoueur1;
		joueur1[1]="5";
		joueur1[2]="0";
		String[] joueur2 = new String[3];
		joueur2[0]=nomJoueur2;
		joueur2[1]="5";
		joueur2[2]="0";
		String[][] joueurs = {joueur1,joueur2};
		
		String[][] mainJoueur1 = new String[5][5];
		mainJoueur1[0] = carte0;
		mainJoueur1[1] = carte1;
		mainJoueur1[2] = carte7;
		mainJoueur1[3] = carte8;
		String[][] mainJoueur2 = new String[5][5];;
		mainJoueur2[0] = carte2;
		mainJoueur2[1] = carte3;
		mainJoueur2[2] = carte9;
		mainJoueur2[3] = carte10;
				
				
		int choixCarte;
		
		Afficheur afficheur = new Afficheur();
		afficheur.lancerJeu();
		afficheur.introduireJeu();
		afficheur.afficherRegles();
		afficheur.afficherAllJoueurs(joueurs);
		afficheur.piocherMain(mainJoueur1,joueur1[0]);
		afficheur.piocherMain(mainJoueur2,joueur2[0]);
		
		
		afficheur.debuterTour(joueur1[0], 1);
		afficheur.piocherCarte(carte12,joueur1[0]);
		afficheur.afficherPlusieursCartes(mainJoueur1);
		choixCarte = afficheur.selectionnerCarte();
		afficheur.jouerCarte(mainJoueur1[choixCarte],joueur1[0],true);
		afficheur.afficherAllJoueurs(joueurs);
		
		afficheur.debuterTour(joueur2[0], 2);
		afficheur.piocherCarte(carte11,joueur2[0]);
		afficheur.afficherPlusieursCartes(mainJoueur2);
		choixCarte = afficheur.selectionnerCarte();
		afficheur.jouerCarte(mainJoueur2[choixCarte],joueur2[0],true);
		afficheur.afficherAllJoueurs(joueurs);

		afficheur.afficherGagnant(nomJoueur2);
	}
}
