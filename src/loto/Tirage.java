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
    private int[] bouleSorties;
    private int bouleGagnante;
    private int resultat;

    public Tirage() {
        MAX_NBRE_BOULES = 49;
        bouleGagnante = 0;
        bouleSorties = new int[6];                      // variable qui va m'aider à vérifier que la boume n'est pas déjà sortie

    }

    public void lancerBoule(int numBoule) {

        do {
            resultat = (int) (Math.random() * MAX_NBRE_BOULES) + 1;     // méthode qui va me donner une boule aléatoirement
            bouleSorties[numBoule] = resultat;
        }
        while (bouleDejaSortie());
        bouleGagnante = resultat;
    }

    private boolean bouleDejaSortie() {                                 // méthode qui vérifie que la boule n'est pas déjà sortie
        int bouleSortie = 0;                                            // perso, je trouve ce code très moyen...
        for (int i = 0; i < bouleSorties.length; i++) {

            if (resultat == bouleSorties[i]) {
                bouleSortie += 1;
            }

        }
        return (bouleSortie == 2);                                      
    }

    public int afficherNumero() {

        return bouleGagnante;
    }

    public void resetBouleSorties() {
        for (int i = 0; i < bouleSorties.length; i++) {
            bouleSorties[i] = 0;

        }

    }
}
