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
public class StatsLoto {

    private final int MAX_JACKPOT;
    private static int cumulTirage;                                   // Static pour éviter que la variable soit remise à zéro après chaque jackpot
    DecimalFormat df = new DecimalFormat("###,###");                  // Format d'affichage de chiffres avec un séparateur de milliers

    public StatsLoto() {

        MAX_JACKPOT = 100;

    }

    public void lancementDuJeu() {

        for (int i = 1; i <= MAX_JACKPOT; i++) {
            new JeuDeLoto().tirage();
        }
        affichageMoyenne();
    }

    public void compteurTirages(int nbreTirage) {

        cumulTirage = cumulTirage + nbreTirage;
    }

    public void affichageMoyenne() {
        System.out.println("----- Pour gagner " + MAX_JACKPOT + " fois le jackpot, il a fallu " + df.format((cumulTirage / MAX_JACKPOT)) + " tirages en moyenne -----");

    }

}
