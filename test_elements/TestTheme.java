/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe TestTheme : Permet de tester la classe Theme.
 */

package test_elements;

import elements.*;

public class TestTheme {
    public static void main(String[] args) {
        // Initialisation des questions de chaque type
        Questions questions1 = new Questions();
        Questions questions2 = new Questions();
        Questions questions3 = new Questions();

        // Initialisation de trois themes
        Theme sciences = new Theme("sciences");
        Theme geographie = new Theme("geographie");
        Theme histoire = new Theme("histoire");

        // Creation de questions de chaque type
        Question qcm = new Qcm("En quelle année a eu lieu la révolution française ?", 1, "1456", "1789", "1998", 2, sciences);
        questions1.addQuestion(qcm);
        Question vf = new Vf("Paris est la capitale de l'Angleterre.", 1, false, geographie);
        questions2.addQuestion(vf);
        Question rc = new Rc("Combien d'heure y a-t-il dans une journée ?", 1, "24", histoire);
        questions3.addQuestion(rc);

        // Ajout des questions dans leur theme respectif
        sciences.setQuestions(questions1);
        geographie.setQuestions(questions2);
        histoire.setQuestions(questions3);

        // Affichage des themes et leur questions
        System.out.println(sciences.getNom() + "\n" + sciences.getQuestions());
        System.out.println(geographie.getNom() + "\n" + geographie.getQuestions());
        System.out.println(histoire.getNom() + "\n" + histoire.getQuestions());
    }
}
