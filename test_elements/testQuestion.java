package test_elements;

import elements.*;

public class testQuestion {
    public static void main(String[] args) {
        Joueur joueur = new Joueur();

        Theme sciences = new Theme("Sciences");

        Question qcm = new Qcm("En quelle année a eu lieu la révolution française ?", 1, "1456", "1789", "1998", 2, sciences);
        System.out.println(qcm);
        //qcm.testBonneReponse(joueur);
        System.out.println(joueur);

        Question vf = new Vf("Paris est la capitale de l'Angleterre.", 1, false, sciences);
        System.out.println(vf);
        //vf.testBonneReponse(joueur);
        System.out.println(joueur);

        Question rc = new Rc("Combien d'heure y a-t-il dans une journée ?", 1, "24", sciences);
        System.out.println(rc);
        //rc.testBonneReponse(joueur);
        System.out.println(joueur);
    }
}
