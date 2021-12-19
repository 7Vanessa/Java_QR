package jeu;

import elements.*;

public class Game {
    public static void main(String []args) {
        PhaseI phaseI = new PhaseI();
        Joueur[] joueursPhaseII = phaseI.playPhase();
        Themes themesPhaseII = phaseI.getThemes();
        PhaseII phaseII = new PhaseII(themesPhaseII);
        phaseII.getJoueursPhaseII().setParticipants(joueursPhaseII);
    }
}
