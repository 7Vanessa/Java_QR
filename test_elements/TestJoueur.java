/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe TestJoueur : Permet de tester la classe Joueur.
 */

package test_elements;

import elements.Joueur;

public class TestJoueur {
    public static void main(String[] args) {
        // Initialisation de joueurs
        Joueur joueur = new Joueur();
        Joueur joueur2 = new Joueur();
        System.out.println(joueur);
        System.out.println(joueur2);
    }
}
