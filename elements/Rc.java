/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Rc : Cette classe hérite de la classe mère Question
 * Il s'agit de la classe qui définit une Rc (Réponse courte) composé d'un
 * attribut bonneRéponse de type String.
 *
 * La méthode principale est la méthode testBonneReponse() qui demande
 * à l'utilisateur de saisir sa réponse et test dans le même temps si la réponse
 * saisie est la bonne.
 */

package elements;

import java.util.Scanner;

public class Rc extends Question {

    private final String bonneReponse;

    /**
     * Constructeur de Rc :
     * Utilise le constructeur de la classe mère Question
     * @param enonce énoncé de la question
     * @param difficulte niveau de difficulté de la question
     * @param bonneReponse bonne réponse de la question
     * @param theme thème associé à la question
     */
    public Rc(String enonce, int difficulte, String bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        this.bonneReponse = bonneReponse;
    }

    /**
     * Demande à l'utilisateur de saisir sa réponse et
     * test si la réponse est correcte.
     * @param joueur correspond au joueur repondant a la question
     * @param nomPhase correspond a la phase actuelle pour determiner le nombre de points gagnes
     * Pas de @return car cette méthode permet de modifier l'attribut score du joueur en cas de bonne réponse
     */
    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) {
        System.out.println("Veuillez saisir votre réponse.");
        Scanner choix = new Scanner(System.in);

        // Saisie de la reponse
        String reponse = choix.next();
        reponse.toLowerCase();
        if(reponse.contains(bonneReponse)) {
            joueur.updateScore(nomPhase);
            System.out.println("Bonne réponse !" + '\n');
        }
        else {
            System.out.println("Mauvaise réponse !" + '\n');
        }
    }

    @Override
    public void saisie() {
        // Pas d'utilite
    }

}
