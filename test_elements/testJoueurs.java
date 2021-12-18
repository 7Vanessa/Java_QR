package test_elements;

import elements.Joueurs;

public class testJoueurs {
    public static void main(String[]args) {
        Joueurs joueurs = new Joueurs(8);
        //Il faut créer le tableau de participants
        joueurs.selectRandomParticipants();
        System.out.println(joueurs);
    }
}
