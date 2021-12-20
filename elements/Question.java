/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Question : Il s'agit de la classe représentant les questions.
 * Il s'agit d'une classe abstraite. Les méthodes abstraites seront définies dans
 * les classes héritant de cette classe, c'est-à-dire les Qcm,
 * Vf et Rc. Une question est composé en independament de sont type
 * (c'est à dire Rc, Qcm et Vf) d'un énoncé, d'une difficulté, d'un thème
 * et d'un numéro.
 */

package elements;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public abstract class Question {

    private final String enonce;

    // Dictionnaire avec : cle = numero, valeur = nom de la difficulte
    // Utilite : rends plus simple l'acces des difficultes par des cles de type "int"
    private final Map<Integer, String> difficultes;
    private static int compteur = 1;
    private final int numero;
    private final int difficulte;
    private Theme theme;

    /**
     * Constructeur de Question :
     * Initialise la map difficultes contenant l'ensemble des difficultés
     * possibles et ajoute ces difficultés à la map difficultes.
     * @param enonce enonce de la question
     * @param difficulte niveau de difficulté de la question (1 (facile), 2 (moyen) ou 3 (difficile))
     * @param theme thème associé à la question
     */
    public Question(String enonce, int difficulte, Theme theme) {
        difficultes = new HashMap<>();
        difficultes.put(1, "Facile");
        difficultes.put(2, "Moyen");
        difficultes.put(3, "Dfficile");
        this.enonce = enonce;
        this.numero = compteur++;
        this.difficulte = difficulte;
        this.theme = theme;
    }

    /**
     * Demande à l'utilisateur de saisir sa réponse et
     * test si la réponse est correcte.
     * @param joueur correspond au joueur repondant a la question
     * @param nomPhase correspond a la phase actuelle pour determiner le nombre de points gagnes
     * @throws InputMismatchException si la reponse n'est pas un entier
     * Pas de @return car cette méthode permet de modifier l'attribut score du joueur en cas de bonne réponse
     */
    public abstract void testBonneReponse(Joueur joueur, String nomPhase);

    public abstract void saisie();

    /**
     * Getter de theme
     * @return l'attribut theme de Question
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Getter de difficulte
     * @return l'attribut difficulte de Question
     */
    public int getDifficulte() {
        return difficulte;
    }

    /**
     * Getter de difficulte
     * @return l'attribut difficulte de Question
     */
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'une question
     */
    @Override
    public String toString() {
        return "Question n°" + numero + "   Difficulté : " + difficultes.get(difficulte) + "   Theme : " + theme.getNom() + '\n' + "Enoncé : " + enonce + '\n';
    }
}
