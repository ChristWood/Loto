package loto;


public class ExoLoto {

    private static int nbreTours;                           // deux variables pour répondre à la question de la moyenne après avoir executer 100 fois l'exercice
    public static int nbreTirageParTour;

    public static void main(String[] args) {
        nbreTours = 100;                                 
        nbreTirageParTour = 0;
        for (int i = 1; i <= nbreTours; i++) {              // début de la boucle des 100 exercices
            new JeuDeLoto().tirage();
        }
        System.out.println("Pour gagner le gros lot, il a fallu " + (nbreTirageParTour / nbreTours) + " tirages en moyenne.");
    }

}
