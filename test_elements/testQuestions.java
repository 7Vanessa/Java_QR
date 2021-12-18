package test_elements;

import elements.*;

public class testQuestions {
    public static void main (String [] args) {
        Questions questions = new Questions();

        Theme sciences = new Theme("Sciences");

        Question qcm = new Qcm("En quelle année a eu lieu la révolution française ?", 1, "1456", "1789", "1998", 2, sciences);
        questions.addQuestion(qcm);
        Question vf = new Vf("Paris est la capitale de l'Angleterre.", 1, false, sciences);
        questions.addQuestion(vf);
        Question rc = new Rc("Combien d'heure y a-t-il dans une journée ?", 1, "24",sciences);
        questions.addQuestion(rc);

        System.out.println(questions);
    }
}
