package elements;

import java.util.Scanner;

public class Rc extends Question {

    private final String bonneReponse;

    public Rc(String enonce, int difficulte, String bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        this.bonneReponse = bonneReponse;
    }

    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) {
        System.out.println("Veuillez saisir votre réponse.");
        Scanner choix = new Scanner(System.in);

        // Saisie de la reponse
        String reponse = choix.next();
        if(reponse.contains(bonneReponse)) {
            joueur.updateScore(nomPhase);
            System.out.println("Bonne réponse !" + '\n');
        }
        else {
            System.out.println("Mauvaise réponse !" + '\n');
        }
    }

    @Override
    public void saisie() {
        // Pas d'utilite
    }

}
