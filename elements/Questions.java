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

    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }

    // Implementation de methodes de selection de question en fonction de la phase
    public Question selectRandQuestion() {
        int indiceQuestion = (int) (Math.random()*(questions.size()-1))+1;
        return questions.get(indiceQuestion);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Question question : questions) {
            str.append(question.toString()).append('\n');
        }
        return str.toString();
    }
}
