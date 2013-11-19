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
public class Joueur {

    private int[] grilleJoueur;
    private int bouleTrouvée;

    public Joueur() {

    }

    public int[] grille() {
        grilleJoueur = new int[]{5, 10, 22, 28, 31, 45};            // grille du joueur composée de 6 chiffres

        return grilleJoueur;
    }

    public void compareGrille(int[] tabResultat) {                  // méthode qui compare la grille du joueur avec le tirage aléatoire

        bouleTrouvée = 0;
        for (int i = 0; i < grille().length; i++) {                 // début de la boucle pour comparer le tableau grille du joueur et le tableau tirage aléatoire
            for (int j = 0; j < tabResultat.length; j++) {

                if (grille()[i] == tabResultat[j]) {
                    bouleTrouvée = bouleTrouvée + 1;                // si la variable bouleTrouvée = 6, c'est le jackpot !
                }
            }
        }
    }

    public int getScore() {
        return bouleTrouvée;
    }
}
