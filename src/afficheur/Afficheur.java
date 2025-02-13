package afficheur;

import java.util.Scanner;

public class Afficheur {
	Scanner scan = new Scanner(System.in);
	
	public void installer() {
		StringBuilder chaine = new StringBuilder("Début du jeu");
		chaine.append("\n\nRappel des règles : ");
		System.out.println(chaine);
	}
	
	public String selectionnerNom(int numeroJoueur) {
		System.out.print("Selectionnez un joueur" + numeroJoueur + " : ");
		return scan.next();
	}
	
	public void piocherCarte(String nomJoueur, int nombreCarte) {
		if (nombreCarte == 1)
			System.out.println(nomJoueur + " pioche une carte");
		else
			System.out.println(nomJoueur + " pioche " + nombreCarte + " cartes");
	}
	
	public void commencer(String nomJoueurStart) {
		System.out.println("Le joueur " + nomJoueurStart + " commence");
	}
	
	public void afficherCarte(String nom, String type, String description, int numeroCarte) {
		StringBuilder chaine = new StringBuilder("Carte" + numeroCarte + " : ");
		chaine.append("- " + nom + " (" + type + ")");
		chaine.append("\n         - " + description);
		System.out.println(chaine);
	}
	
	public int reaficherCartes() {
		int reponse = 0;
		System.out.println("Voulez vous réaficher les autres cartes ?");
		StringBuilder chaine = new StringBuilder("\n0 : non et 1 : oui");
		
		do {
			System.out.println(chaine);
			reponse = Integer.parseInt(scan.next());
		}while (!(reponse == 0 || reponse == 1));
		return reponse;
	}
	
	
	
	public static void main(String[] args) {
		Afficheur afficheur = new Afficheur();
		afficheur.installer();
		System.out.println("");
		String nom1 = "BILL"; //afficheur.selectionnerNom(1);
		//System.out.println(nom1);
		afficheur.piocherCarte(nom1, 1);
		afficheur.afficherCarte("Lance une flèche", "Attaque", "enlève 2 vies à l'adversaire", 1);
		System.out.println("");
		afficheur.commencer(nom1);	
		
		System.out.println(afficheur.reaficherCartes());
	}
}
