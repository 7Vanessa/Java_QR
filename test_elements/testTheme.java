package test_elements;

import elements.*;

public class testTheme {
    public static void main(String[] args) {
        Questions questions1 = new Questions();
        Questions questions2 = new Questions();
        Questions questions3 = new Questions();

        Theme sciences = new Theme("Sciences");
        Theme art = new Theme("Art");
        Theme histoire = new Theme("Histoire");

        Question qcm = new Qcm("En quelle année a eu lieu la révolution française ?", 1, "1456", "1789", "1998", 2, sciences);
        questions1.addQuestion(qcm);
        Question vf = new Vf("Paris est la capitale de l'Angleterre.", 1, false, art);
        questions2.addQuestion(vf);
        Question rc = new Rc("Combien d'heure y a-t-il dans une journée ?", 1, "24", histoire);
        questions3.addQuestion(rc);

        sciences.setQuestions(questions1);
        art.setQuestions(questions2);
        histoire.setQuestions(questions3);
        System.out.println(sciences);
        System.out.println(art);
        System.out.println(histoire);
    }
}
