package test_elements;

import elements.*;

public class testQuestion {
    public static void main(String[] args) {
        // Initialisation d'un joueur
        Joueur joueur = new Joueur();

        // Initialisation d'un theme
        Theme sciences = new Theme("Sciences");

        // Initialisation d'une question de chaque type + reponse du joueur
        Question qcm = new Qcm("En quelle année a eu lieu la révolution française ?", 1, "1456", "1789", "1998", 2, sciences);
        System.out.println(qcm);
        qcm.testBonneReponse(joueur, "phaseI");
        System.out.println(joueur);

        Question vf = new Vf("Paris est la capitale de l'Angleterre.", 1, false, sciences);
        System.out.println(vf);
        vf.testBonneReponse(joueur, "phaseI");
        System.out.println(joueur);

        Question rc = new Rc("Combien d'heure y a-t-il dans une journée ?", 1, "24", sciences);
        System.out.println(rc);
        rc.testBonneReponse(joueur, "phaseI");
        System.out.println(joueur);
    }
}
