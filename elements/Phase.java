package elements;

import java.util.List;

public interface Phase {
    public Joueurs selectJoueurs();
    public Joueur[] playPhase();
    public String getNomPhase();
    int choixNbJoueurs();
    void questionsDifficulte(int tour, Theme theme);
    void autresQuestions(int tour, Theme theme, int nbQuestions, int indiceTheme, List<Theme> ThemesPhase);
    void elimination(int nbJoueurs);
    void affichagePhase();
}
