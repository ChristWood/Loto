/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loto;

/**
 *
 * @author Christophe
 */
public class Tirage {

    private final int MAX_NBRE_BOULES;
    private int bouleGagnante;
    private int bouleTiréeAuSort;
    private int[] boulesEnJeu;

    public Tirage() {
        MAX_NBRE_BOULES = 49;
        bouleGagnante = 0;
        boulesEnJeu = new int[MAX_NBRE_BOULES + 1];                    // Tableau qui stocke les 49 boules en jeu
    }

    public void boulesEnJeu() {

        for (int i = 0; i < (MAX_NBRE_BOULES + 1); i++) {             // Remplissage du boulier avec les 49 boules
            boulesEnJeu[i] = i;
        }
    }

    public void lancerBoule() {                                       // méthode qui va me donner une boule aléatoirement

        do {
            bouleTiréeAuSort = (int) (Math.random() * MAX_NBRE_BOULES) + 1;
        }
        while (bouleDejaSortie());
        bouleGagnante = bouleTiréeAuSort;
        boulesEnJeu[bouleTiréeAuSort] = 0;                             // Mise à jour du tableau des 49 boules. La boule gagnante n'existe plus dans le boulier, 
    }                                                                  // et ne pourra donc plus être jouée.

    private boolean bouleDejaSortie() {                                // méthode qui vérifie que la boule n'est pas déjà sortie

        boolean test = false;

        if (boulesEnJeu[bouleTiréeAuSort] == bouleTiréeAuSort) {        // Si la boule tirée au sort est encore dans le tableau des 49 boules en jeu, alors elle n'est pas encore sortie.
            test = false;
        }
        else if (boulesEnJeu[bouleTiréeAuSort] == 0) {
            test = true;
        }
        return test;
    }

    public int afficherNumero() {
        return bouleGagnante;
    }
}
