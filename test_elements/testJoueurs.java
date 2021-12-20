package test_elements;

import elements.Joueurs;

public class testJoueurs {
    public static void main(String[]args) {
        // Initialisation des joueurs de la partie, ici 8 participants
        Joueurs joueurs = new Joueurs(8);

        // Associe a chaque joueur un personnage
        joueurs.selectRandomParticipants();

        System.out.println(joueurs);
    }
}
