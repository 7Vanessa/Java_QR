/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Vf : Cette classe hérite de la classe mère Question.
 * Il s'agit de la classe qui définit une Vf (Vrai Faux) composé d'un
 * attribut bonneRéponse de type boolean.
 *
 * La méthode principale est la méthode testBonneReponse() qui demande
 * à l'utilisateur de saisir sa réponse et test dans le même temps si la réponse
 * saisie est la bonne. Les exceptions y sont gérées.
 */

package elements;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vf extends Question {

    private final boolean bonneReponse;

    /**
     * Constructeur de Vf :
     * Utilise le constructeur de la classe mère Question
     * @param enonce énoncé de la question
     * @param difficulte niveau de difficulté de la question
     * @param bonneReponse bonne réponse de la question
     * @param theme thème associé à la question
     */
    public Vf(String enonce, int difficulte, boolean bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        this.bonneReponse = bonneReponse;
    }

    /**
     * Demande à l'utilisateur de saisir sa réponse et
     * test si la réponse est correcte.
     * @param joueur correspond au joueur repondant a la question
     * @param nomPhase correspond a la phase actuelle pour determiner le nombre de points gagnes
     * @throws InputMismatchException si la reponse n'est pas un boolean
     * Pas de @return car cette méthode permet de modifier l'attribut score du joueur en cas de bonne réponse
     */
    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) throws InputMismatchException {
        System.out.println("Veuillez saisir votre réponse. (true ou false)");
        Scanner choix = new Scanner(System.in);


        // Tant que la reponse saisie n'est pas un booleen...
        try {
            boolean reponse = choix.nextBoolean();
            if(reponse == bonneReponse) {
                joueur.updateScore(nomPhase);
                System.out.println("Bonne réponse !" + '\n');
            }
            else {
                System.out.println("Mauvaise réponse !" + '\n');
            }
        }

        // ...on recommence la saisie
        catch(InputMismatchException e) {
            System.out.println("Saisie incorrect! Veuillez recommencer.");
            testBonneReponse(joueur, nomPhase);
        }
    }

    @Override
    public void saisie() {
        // Pas d'utilite
    }
}
