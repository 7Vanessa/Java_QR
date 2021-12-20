package elements;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Qcm extends Question {

    // Dictionnaire avec : cle = numero de la reponse, valeur = texte de la reponse
    private final Map<Integer, String> propositions;
    private final int bonneReponse;

    public Qcm(String enonce, int difficulte, String proposition1, String proposition2, String proposition3, int bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        propositions = new HashMap<>();
        propositions.put(1, proposition1);
        propositions.put(2, proposition2);
        propositions.put(3, proposition3);
        this.bonneReponse = bonneReponse;
    }

    /**
     * Saisie d'une reponse et validation
     * @param joueur correspond au joueur repondant a la question
     * @param nomPhase correspond a la phase actuelle pour determiner le nombre de points gagnes
     * @throws InputMismatchException si la reponse n'est pas un entier
     */
    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) throws InputMismatchException {
        // L'utilisateur rentre le numero de la reponse
        System.out.println("Veuillez saisir votre réponse. (1 / 2 / 3)");
        Scanner choix = new Scanner(System.in);

        // Tant que la saisie n'est pas un nombre...
        try {
            int reponse = choix.nextInt();
            if (reponse != 1 && reponse != 2 && reponse != 3) {
                System.out.println("Saisie incorrecte! Veuillez recommencer.");
                testBonneReponse(joueur, nomPhase);
            } else if (reponse == bonneReponse) {
                joueur.updateScore(nomPhase);
                System.out.println("Bonne réponse !" + '\n');
            }
            else
                System.out.println("Mauvaise réponse !" + '\n');
        }

        // ...on recommence la saisie
        catch(InputMismatchException e) {
            System.out.println("Saisie incorrecte! Veuillez recommencer." + '\n');
            testBonneReponse(joueur, nomPhase);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "1) " + propositions.get(1) + '\n' + "2) " + propositions.get(2) + '\n' + "3) " + propositions.get(3) + '\n';
    }

    @Override
    public void saisie() {
        // Pas d'utilite
    }
}
