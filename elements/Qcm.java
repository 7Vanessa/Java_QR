/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Qcm : Cette classe hérite de la classe mère Question
 * Il s'agit de la classe qui définit un Qcm composé d'un attribut Map
 * permettant de représenter les 3 propositions associé chacune
 * à une clé correspondant au numéro de la proposition, et d'un entier
 * représentant la bonne, associé au numéro de la proposition.
 *
 * La méthode principale est la méthode testBonneReponse() qui demande
 * à l'utilisateur de saisir sa réponse et test dans le même temps si la réponse
 * saisie est la bonne. Les exceptions y sont gérées.
 */

package elements;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Qcm extends Question {

    // Dictionnaire avec : cle = numero de la reponse, valeur = texte de la reponse
    private final Map<Integer, String> propositions;
    private final int bonneReponse;

    /**
     * Constructeur de Qcm :
     * Utilise le constructeur de la class mère Question
     * Initialise la map propositions contenant l'ensemble des propositions de
     * la question et ajoute ces propositions à la map propositions.
     * @param enonce enonce de la question
     * @param difficulte niveau de difficulté de la question (1 (facile), 2 (moyen) ou 3 (difficile))
     * @param proposition1 première proposition de la question
     * @param proposition2 deuxième proposition de la question
     * @param proposition3 troisième proposition de la question
     * @param bonneReponse numéro de la bonne réponse de la question
     * @param theme thème associé à la question
     */
    public Qcm(String enonce, int difficulte, String proposition1, String proposition2, String proposition3, int bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        propositions = new HashMap<>();
        propositions.put(1, proposition1);
        propositions.put(2, proposition2);
        propositions.put(3, proposition3);
        this.bonneReponse = bonneReponse;
    }

    /**
     * Demande à l'utilisateur de saisir sa réponse et
     * test si la réponse est correcte.
     * @param joueur correspond au joueur repondant a la question
     * @param nomPhase correspond a la phase actuelle pour determiner le nombre de points gagnes
     * @throws InputMismatchException si la reponse n'est pas un entier
     * Pas de @return car cette méthode permet de modifier l'attribut score du joueur en cas de bonne réponse
     */
    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) throws InputMismatchException {
        // L'utilisateur rentre le numero de la reponse
        System.out.println("Veuillez saisir votre réponse. (1 / 2 / 3)");
        Scanner choix = new Scanner(System.in);

        // Tant que la saisie n'est pas un nombre...
        try {
            int reponse = choix.nextInt();
            if (reponse != 1 && reponse != 2 && reponse != 3) {
                System.out.println("Saisie incorrecte! Veuillez recommencer.");
                testBonneReponse(joueur, nomPhase);
            } else if (reponse == bonneReponse) {
                joueur.updateScore(nomPhase);
                System.out.println("Bonne réponse !" + '\n');
            }
            else
                System.out.println("Mauvaise réponse !" + '\n');
        }

        // ...on recommence la saisie
        catch(InputMismatchException e) {
            System.out.println("Saisie incorrecte! Veuillez recommencer." + '\n');
            testBonneReponse(joueur, nomPhase);
        }
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'un objet Qcm
     */
    @Override
    public String toString() {
        return super.toString() + "1) " + propositions.get(1) + '\n' + "2) " + propositions.get(2) + '\n' + "3) " + propositions.get(3) + '\n';
    }

    @Override
    public void saisie() {
        // Pas d'utilite
    }
}
