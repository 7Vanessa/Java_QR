/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe TestQuestions : Permet de tester la classe Questions.
 */

package test_elements;

import elements.*;

public class TestQuestions {
    public static void main (String [] args) {
        // Initialisation d'une "liste" de questions
        Questions questions = new Questions();

        // Initialisation d'un theme
        Theme sciences = new Theme("sciences");

        // Ajout des questions dans la liste
        Question qcm = new Qcm("En quelle année a eu lieu la révolution française ?", 1, "1456", "1789", "1998", 2, sciences);
        questions.addQuestion(qcm);
        Question vf = new Vf("Paris est la capitale de l'Angleterre.", 1, false, sciences);
        questions.addQuestion(vf);
        Question rc = new Rc("Combien d'heure y a-t-il dans une journée ?", 1, "24",sciences);
        questions.addQuestion(rc);

        System.out.println(questions);
    }
}
