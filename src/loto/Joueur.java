/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loto;

import java.text.DecimalFormat;

/**
 *
 * @author Christophe
 */
public class Joueur {

    private int[] grilleJoueur;
    DecimalFormat df = new DecimalFormat("###,###");    // Format d'affichage de chiffres avec un séparateur de milliers

    public Joueur() {

    }

    public int[] grille() {
        grilleJoueur = new int[]{5, 22, 31, 28, 10, 45};            // grille du joueur composée de 6 chiffres
        return grilleJoueur;
    }

    public void jackPot(int nbreTirage) {
        System.out.println("Bravo ! Vous avez gagné le jackpot !!");
        System.out.println("Il a fallu " + df.format(nbreTirage) + " tirages.");
    }
}
