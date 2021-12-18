package elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Qcm extends Question {

    private Map<Integer, String> propositions;
    private final int bonneReponse;

    public Qcm(String enonce, int difficulte, String proposition1, String proposition2, String proposition3, int bonneReponse, Theme theme) {
        super(enonce, difficulte, theme);
        propositions = new HashMap<>();
        propositions.put(1, proposition1);
        propositions.put(2, proposition2);
        propositions.put(3, proposition3);
        this.bonneReponse = bonneReponse;
    }

    public int getBonneReponse() {
        return bonneReponse;
    }

    @Override
    public void testBonneReponse(Joueur joueur, String nomPhase) {
        System.out.println("Veuillez saisir votre réponse. (1, 2 ou 3)");
        Scanner choix = new Scanner(System.in);
        int reponse = choix.nextInt();
        if(reponse != 1 && reponse != 2 && reponse != 3) {
            System.out.println("Saisie incorrect! Veuillez recommencer.");
            testBonneReponse(joueur, nomPhase);
        }
        else if(reponse == bonneReponse) {
            joueur.updateScore(nomPhase);
            System.out.println("Bonne réponse !" + '\n');
        }
        else {
            System.out.println("Mauvaise réponse :(" + '\n');
        }
    }

    @Override
    public String toString() {
        return super.toString() + "1) " + propositions.get(1) + '\n' + "2) " + propositions.get(2) + '\n' + "3) " + propositions.get(3) + '\n';
    }

    @Override
    public void saisie() {
    }
}
