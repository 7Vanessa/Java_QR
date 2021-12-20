package test_elements;

import elements.Joueur;
import elements.PhaseI;
import elements.PhaseII;
import elements.Themes;

public class testPhaseII {
    public static void main(String[] args) {
        // Necessite d'une phase I pour recuperer en sortie les joueurs pour la phase II
        PhaseI phaseI = new PhaseI();
        Joueur[] joueursPhaseII = phaseI.playPhase();

        // On recupere les memes themes (contenant deja les questions) de la phase I pour la phase II
        Themes themesPhaseII = phaseI.getThemes();
        PhaseII phaseII = new PhaseII(themesPhaseII);
        phaseII.getJoueursPhaseII().setParticipants(joueursPhaseII);
        phaseII.playPhase();
    }
}
