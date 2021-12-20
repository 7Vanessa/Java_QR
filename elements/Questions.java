package elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Questions implements Iterable<Question> {

    private final List<Question> questions;

    public Questions() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(int indice) {
        questions.remove(indice);
    }

    /**
     * Iterateur sur l'attribut de la classe (List)
     * @return l'iterateur de la liste
     */
    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }

    /**
     * Selectionne une question au hasard dans la liste des questions
     * @return la question choisie au hasard
     */
    public Question selectRandQuestion(int indice) {
        return questions.get(indice);
    }

    public Question selectRandQuestion() {
        int indice = (int) (Math.random()*(questions.size()-1))+1;
        return questions.get(indice);
    }

    public int indiceRandQuestions() {
        return (int) (Math.random()*(questions.size()-1))+1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Question question : questions) {
            str.append(question.toString()).append('\n');
        }
        return str.toString();
    }

    // Getter
    public List<Question> getQuestions() {
        return questions;
    }
}
