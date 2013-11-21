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
    private int bouleAuHasard;
    private int[] boulesLoto;

    public Tirage() {
        MAX_NBRE_BOULES = 49;
        bouleGagnante = 0;
        boulesLoto = new int[MAX_NBRE_BOULES + 1];                    // Tableau qui stocke les 49 boulesEnJeu
    }

    public void boulesEnJeu() {

        for (int i = 0; i < (MAX_NBRE_BOULES + 1); i++) {             // Remplissage du tableau avec les 49 boulesEnJeu
            boulesLoto[i] = i;
        }
    }

    public void lancerBoule() {                                      // méthode qui va me donner une boule aléatoirement

        do {
            bouleAuHasard = (int) (Math.random() * MAX_NBRE_BOULES) + 1;
        }
        while (bouleDejaSortie());
        bouleGagnante = bouleAuHasard;
        boulesLoto[bouleAuHasard] = 0;                                 // Mise à jour du tableau des 49 boulesEnJeu. La place qu'occupait la boule gagnante porte maintenant la valeur 0.
    }                                                                  // Et ne pourra donc plus être jouée.

    private boolean bouleDejaSortie() {                                // méthode qui vérifie que la boule n'est pas déjà sortie

        boolean test = false;

        if (boulesLoto[bouleAuHasard] == bouleAuHasard) {
            test = false;
        }
        else if (boulesLoto[bouleAuHasard] == 0) {
            test = true;
        }
        return test;
    }

    public int afficherNumero() {

        return bouleGagnante;
    }
}
