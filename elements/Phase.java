package elements;

public interface Phase {
    Joueurs selectJoueurs();
    Joueur[] playPhase();
    void elimination(int nbJoueurs);
    void affichagePhase();
}
