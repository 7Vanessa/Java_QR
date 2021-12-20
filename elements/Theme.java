/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Theme : Cette classe permet de définir un thème qui est
 * composé d'un attribut nom et d'un attribut questions qui est une
 * liste de questions.
 */

package elements;

public class Theme {

    private final String nom;
    private Questions questions;

    /**
     * Constructeur de Theme :
     * Initialise un objet de type Questions
     */
    public Theme(String nom) {
        this.nom = nom;
        questions = new Questions();
    }

    /**
     * Getter de questions
     * @return l'attribut questions de Theme
     */
    public Questions getQuestions() {
        return questions;
    }

    /**
     * Getter de nom
     * @return l'attribut nom de Theme
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de questions
     * @param questions liste de questions du thème
     * Pas de @return pour un setter, modifie juste l'attribut questions
     */
    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'un objet Theme
     */
    @Override
    public String toString() {
        return nom;
    }
}
