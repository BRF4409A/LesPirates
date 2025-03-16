package jeu;

import java.security.SecureRandom;

public class Pioche {

	private Carte[] pioche = new Carte[86];  //(4*4+1) *5
	private int index = 0;
	
    private SecureRandom random;
    
    public Pioche() {
    	pioche[index++] = new CarteFinale("Trésor caché", 5, "Vous trouvez un trésor caché et gagnez directement la partie");
    	for (int i = 0; i < 5; i++) {
    		pioche[index++] = new CarteAttaque("Attaque Sournoise", 1, "Une attaque nette aux coudes");
            pioche[index++] = new CarteAttaque("Coup de Bouteille", 1, "Attaque avec une bouteille");
            pioche[index++] = new CarteAttaque("Lancer de Dague", 1, "Lancer rapide de dague");
    		pioche[index++] = new CarteAttaque("Coup de Crochet", 2, "Une attaque puissante");
        
            pioche[index++] = new CartePopularite("Discours Brutal", 1, "Discours �nergique");
            pioche[index++] = new CartePopularite("Trahison Malicieuse", 1, "Trahison pour augmenter la popularit�");
            pioche[index++] = new CartePopularite("Discours Sinc�re", 2, "Un discours charmant");
            pioche[index++] = new CartePopularite("Chant de Pirate", 2, "Chant motivant pour les troupes");
            
            pioche[index++] = new CarteDiffamation("Ragots", 1, "Mensonges sur place publique");
            pioche[index++] = new CarteDiffamation("Manipulation de Presse", 1, "Scandale pour d�truire la r�putation");
            pioche[index++] = new CarteDiffamation("Calomnie Strat�gique", 1, "Accusations infond�es pour perdre de la popularit�");
            pioche[index++] = new CarteDiffamation("Diffamation Publique", 2, "Une rumeur d�vastatrice contre l'adversaire");
            
            pioche[index++] = new CarteSoin("Potion de Vie", 1, "Une potion qui soigne");
            pioche[index++] = new CarteSoin("Bandages", 1, "Panse les petits bobos");
            pioche[index++] = new CarteSoin("Décoction de racines", 1, "Reméde revigorant à base de plante");
            pioche[index++] = new CarteSoin("Grog", 2, "Remede revigorant à base de rhum");
            
            pioche[index++] = new CarteCopier("Petit filou", "Copie une carte de ton choix depuis la main de ton adversaire");
        }
    	index = 0;
    	
    	try {
            random = SecureRandom.getInstanceStrong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void melangerPioche() {
    	int randomIndex;
    	Carte carteTempo;
    	 for (int i = 0; i < pioche.length; i++) {
             randomIndex = random.nextInt(pioche.length); 
             carteTempo = pioche[i];
             pioche[i] = pioche[randomIndex];
             pioche[randomIndex] = carteTempo;
         }
    }
    
    public Carte piocherCarte() {
    	if (index > pioche.length) {
    		index = 0;
    	}
    	Carte carte = pioche[index];
    	index++;
    	return carte;
    }
}
