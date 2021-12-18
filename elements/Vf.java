package elements;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vf extends Question {

    private final boolean bonneReponse;

    public Vf(String enonce, int difficulte, boolean bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        this.bonneReponse = bonneReponse;
    }

    public boolean getBonneReponse() {
        return bonneReponse;
    }

    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) throws InputMismatchException {
        System.out.println("Veuillez saisir votre réponse. (true ou false)");
        Scanner choix = new Scanner(System.in);
        try {
            Boolean reponse = choix.nextBoolean();
            if(reponse == bonneReponse) {
                joueur.updateScore(nomPhase);
                System.out.println("Bonne réponse !" + '\n');
            }
            else {
                System.out.println("Mauvaise réponse :(" + '\n');
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Saisie incorrect! Veuillez recommencer.");
            testBonneReponse(joueur, nomPhase);
        }
    }

    @Override
    public void saisie() {

    }
}
