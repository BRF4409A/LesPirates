package jeu;

import java.security.SecureRandom;

public class Pioche {

	private Carte[] pioche = new Carte[86];  //(4*4+1) *5
	public int index = 0;
	
    private SecureRandom random;
    
    public Pioche() {
    	pioche[index] = new CarteSoin("Grog", 2, "Remède revigorant à base de rhum");
    	for (int i = 0; i < 5; i++) {
    		pioche[index++] = new CarteAttaque("Attaque Sournoise", 1, "Une attaque nette aux coudes");
    		pioche[index++] = new CarteAttaque("Coup de Crochet", 2, "Une attaque puissante");
            pioche[index++] = new CarteAttaque("Coup de Bouteille", 1, "Attaque avec une bouteille");
            pioche[index++] = new CarteAttaque("Lancer de Dague", 1, "Lancer rapide de dague");
        
            pioche[index++] = new CartePopularite("Discours Sincère", 2, "Un discours charmant");
            pioche[index++] = new CartePopularite("Chant de Pirate", 2, "Chant motivant pour les troupes");
            pioche[index++] = new CartePopularite("Discours Brutal", 1, "Discours énergique");
            pioche[index++] = new CartePopularite("Trahison Malicieuse", 1, "Trahison pour augmenter la popularité");
        
            pioche[index++] = new CarteDiffamation("Diffamation Publique", 2, "Une rumeur dévastatrice contre l'adversaire");
            pioche[index++] = new CarteDiffamation("Ragots", 1, "Mensonges sur place publique");
            pioche[index++] = new CarteDiffamation("Manipulation de Presse", 1, "Scandale pour détruire la réputation");
            pioche[index++] = new CarteDiffamation("Calomnie Stratégique", 1, "Accusations infondées pour perdre de la popularité");
       
            pioche[index++] = new CarteSoin("Potion de Vie", 1, "Une potion qui soigne");
            pioche[index++] = new CarteSoin("Bandages", 1, "Panse les petits bobos");
            pioche[index++] = new CarteSoin("Décoction de racines", 1, "Remède revigorant à base de plante");
            pioche[index++] = new CarteSoin("Grog", 2, "Remede revigorant à base de rhum");
            
            pioche[index++] = new CarteSoin("Grog", 2, "Remède revigorant à base de rhum");
        }
    	
    	index = 0;
    }
}
