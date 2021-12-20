package elements;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vf extends Question {

    private final boolean bonneReponse;

    public Vf(String enonce, int difficulte, boolean bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        this.bonneReponse = bonneReponse;
    }

    /**
     * Saisie d'une reponse et validation
     * @param joueur correspond au joueur repondant a la question
     * @param nomPhase correspond a la phase actuelle pour determiner le nombre de points gagnes
     * @throws InputMismatchException si la reponse n'est pas un booleen
     */
    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) throws InputMismatchException {
        System.out.println("Veuillez saisir votre réponse. (true ou false)");
        Scanner choix = new Scanner(System.in);


        // Tant que la reponse saisie n'est pas un booleen...
        try {
            boolean reponse = choix.nextBoolean();
            if(reponse == bonneReponse) {
                joueur.updateScore(nomPhase);
                System.out.println("Bonne réponse !" + '\n');
            }
            else {
                System.out.println("Mauvaise réponse !" + '\n');
            }
        }

        // ...on recommence la saisie
        catch(InputMismatchException e) {
            System.out.println("Saisie incorrect! Veuillez recommencer.");
            testBonneReponse(joueur, nomPhase);
        }
    }

    @Override
    public void saisie() {
        // Pas d'utilite
    }
}
