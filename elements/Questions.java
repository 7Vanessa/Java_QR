/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Questions : Cette classe permet de représenter une liste de questions
 * Une liste de question est composé de questions de niveaux différents
 * et de type (Qcm, Vf et Rc) différents, cependant toutes les questions
 * d'une liste ont le même thème.
 */

package elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Questions implements Iterable<Question> {

    private final List<Question> questions;

    /**
     * Constructeur de Questions :
     * Initialise une liste de Question
     */
    public Questions() {
        questions = new ArrayList<>();
    }

    /**
     * Permet d'ajouter une question à la liste de questions
     * @param question question à ajouter à la liste
     * Pas de @return car cette méthode modifie juste l'attribut questions
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Permet de supprimer une question de la liste de questions
     * @param indice indice de la question à supprimer
     * Pas de @return car elle modifie juste l'attribut questions
     */
    public void removeQuestion(int indice) {
        questions.remove(indice);
    }

    /**
     * Iterateur sur l'attribut questions de la classe (List)
     * @return l'iterateur de la liste
     */
    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }

    /**
     * Selectionne une question au hasard dans la liste des questions
     * @param indiceQuestion indice d'une question choisie au hasard dans la liste de question
     * @return la question choisie au hasard
     */
    public Question selectRandQuestion(int indiceQuestion) {
        return questions.get(indiceQuestion);
    }

    /**
     * Selectionne une question aléatoirement dans la liste des questions
     * @return la question choisie aléatoirement dans la liste de questions
     */
    public Question selectRandQuestion() {
        int indice = (int) (Math.random()*(questions.size()-1))+1;
        return questions.get(indice);
    }

    /**
     * Selectionne un indice pris aléatoirement dans la liste de questions
     * @return un entier correspondant à un indice pris au hasard dans la
     * liste de questions
     */
    public int indiceRandQuestions() {
        return (int) (Math.random()*(questions.size()-1))+1;
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'un objet Questions
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Question question : questions) {
            str.append(question.toString()).append('\n');
        }
        return str.toString();
    }

    /**
     * Getter de questions
     * @return l'attribut questions de Questions
     */
    public List<Question> getQuestions() {
        return questions;
    }
}
