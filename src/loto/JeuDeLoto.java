/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loto;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 *
 * @author Christophe
 */
public class JeuDeLoto {

    public Tirage tirage;
    public Joueur joueur;
    public StatsLoto statsLoto;
    private final int MAX_BOULES_PAR_TIRAGE;
    public int[] resultatTirage;                           // resultatTirage sert à stocker les 6 chiffres tirés aléatoirement par le jeu
    private int nbreTirage;
    boolean grilleGagnante;
    DecimalFormat df = new DecimalFormat("###,###");       // Format d'affichage de chiffres avec un séparateur de milliers

    public JeuDeLoto() {
        tirage = new Tirage();
        joueur = new Joueur();
        statsLoto = new StatsLoto();
        MAX_BOULES_PAR_TIRAGE = 6;                         // variable qui dit combien de boules sont tirées pour chaque tirage
        resultatTirage = new int[MAX_BOULES_PAR_TIRAGE];

    }

    public void tirage() {
        tirage.boulesEnJeu();
        while (grillePerdante()) {                                      // début du tirage aléatoire. Il dure tant que le joueur n'a pas eu les 6 chiffres gagnants
            for (int i = 0; i < MAX_BOULES_PAR_TIRAGE; i++) {
                tirage.lancerBoule();                                   // méthode qui va donner la boule aléatoire
                resultatTirage[i] = tirage.afficherNumero();            // méthode qui stock le chiffre de la boule
            }
            compareGrille(resultatTirage, joueur.grille());             // une fois que les boules sont tirées, le joueur compare le résultat avec sa grille
            nbreTirage += 1;
            tirage.boulesEnJeu();                                       // le joueur a fini de comparer sa grille. Un nouveau tirage va recommencer, les 49 boules sont remises dans le boulier
        }
        envoyerInfos();                                                 // En cas de grille gagnante, on appelle cette méthode
    }

    public void compareGrille(int[] resultatTirage, int[] joueurGrille) {
        grilleGagnante = false;
        Arrays.sort(joueurGrille);                                                // la joueurGrille du joueur est triée par ordre croissant
        Arrays.sort(resultatTirage);                                              // la joueurGrille du tirage est triée par ordre croissant
        //        String $resultatTirage= Arrays.toString(resultatTirage);
        //        String $grille= Arrays.toString(joueurGrille);
        //        System.out.println($grille);
        //        System.out.println($resultatTirage);
        if (Arrays.equals(resultatTirage, joueurGrille)) {                        // si les deux grilles sont égales, alors c'est gagné !
            grilleGagnante = true;
        }
    }

    private boolean grillePerdante() {
        return (!grilleGagnante);
    }

    private void envoyerInfos() {
        joueur.jackPot(nbreTirage);
        statsLoto.compteurTirages(nbreTirage);
    }
}
