/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Interface Phase implémenté par les 3 phases du jeu
 */

package elements;

public interface Phase {
    /**
     * Permet de selectionner la liste des joueurs participants
     * @return la un objets Joueurs qui est la liste des joueurs participants
     */
    Joueurs selectJoueurs();

    /**
     * Lancement de la phase
     * @return la liste des joueurs ayant participé à la phase avec leur etat mis à jour
     */
    Joueur[] playPhase();

    /**
     * Correspond a la partie de la phase avec l'elimination des perdants
     * @param nbJoueurs correspond au nombre de joueurs
     * Pas de @return car cette méthode permet juste de modifier l'etat des joueurs à l'issu de la phase,
     * en Eliminé ou Gagnant
     */
    void elimination(int nbJoueurs);

    /**
     * Correspond a l'affichage du resultat final de la phase
     * Pas de @return car utilisation de System.out.println
     */
    void affichagePhase();
}
