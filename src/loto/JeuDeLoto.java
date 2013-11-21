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
public class JeuDeLoto {

    public Tirage tirage;
    public Joueur joueur;
    private final int MAX_BOULES_PAR_TIRAGE;
    public int[] tabResultat;                           // tabResultat sert à stocker les 6 chiffres tirés aléatoirement par le jeu
    private int nbreTirage;
    DecimalFormat df = new DecimalFormat("###,###");    // Format d'affichage de chiffres avec un séparateur de milliers

    public JeuDeLoto() {
        tirage = new Tirage();
        joueur = new Joueur();
        MAX_BOULES_PAR_TIRAGE = 6;                      // variables qui dit combien de boules sont tirées pour chaque tirage
        tabResultat = new int[MAX_BOULES_PAR_TIRAGE];
        nbreTirage = 0;

    }

    public void tirage() {

        tirage.boulesEnJeu();
        while (grillePerdante()) {                                      // début du tirage aléatoire. Il dure tant que le joueur n'a pas eu les 6 chiffres gagnants
            for (int i = 0; i < MAX_BOULES_PAR_TIRAGE; i++) {
                tirage.lancerBoule();                                   // méthode qui va donner la boule aléatoire
                tabResultat[i] = tirage.afficherNumero();               // méthode qui stock le chiffre de la boule
            }
            joueur.compareGrille(tabResultat);                          // une fois que toutes les boules du tirage sont tirées, le joueur compare le résultat avec sa grille
            nbreTirage += 1;
            tirage.boulesEnJeu();                                       // le joueur a fini de comparer sa grille. Les 49 boules sont remises en jeu
        }
        jackPot();
    }

    private boolean grillePerdante() {
        return (joueur.getScore() != joueur.grille().length);

    }

    private void jackPot() {
        System.out.println("Bravo ! Vous avez gagné le jackpot !!");
        System.out.println("Il a fallu " + df.format(nbreTirage) + " tirages.");
        ExoLoto.nbreTirageParTour = ExoLoto.nbreTirageParTour + nbreTirage;
    }
}
