package elements;

import java.util.List;
import java.util.Map;

public interface Phase {
    Joueurs selectJoueurs();
    Joueur[] playPhase();
    void elimination(int nbJoueurs);
    void affichagePhase();
}
