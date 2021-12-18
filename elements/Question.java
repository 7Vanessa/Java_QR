package elements;

import java.util.HashMap;
import java.util.Map;

public abstract class Question {

    private final String enonce;
    private final Map<Integer, String> difficultes;
    private static int compteur = 1;
    private final int numero;
    private final int difficulte;
    private Theme theme;

    public Question(String enonce, int difficulte, Theme theme) {
        difficultes = new HashMap<>();
        difficultes.put(1, "Facile");
        difficultes.put(2, "Moyen");
        difficultes.put(3, "Dfficile");
        this.enonce = enonce;
        this.numero = compteur++;
        this.difficulte = difficulte;
        this.theme = theme;
    }

    public abstract void testBonneReponse(Joueur joueur, String nomPhase);

    public abstract void saisie();

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Theme getTheme() {
        return theme;
    }

    public int getDifficulte() {
        return difficulte;
    }

    @Override
    public String toString() {
        return "Question n°" + numero + "   Difficulté : " + difficultes.get(difficulte) + "   Theme : " + theme.getNom() + '\n' + "Enoncé : " + enonce + '\n';
    }
}
