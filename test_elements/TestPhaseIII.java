/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe TestPhaseIII : Permet de tester la classe PhaseIII.
 */

package test_elements;

import elements.*;

public class TestPhaseIII {
    public static void main(String[] Args) {
        // Necessite d'une phase I pour recuperer en sortie les joueurs pour la phase II
        PhaseI phaseI = new PhaseI();
        Joueur[] joueursPhaseII = phaseI.playPhase();

        // On recupere les memes themes (contenant deja les questions) de la phase I pour la phase II
        Themes themesPhaseII = phaseI.getThemes();

        // Necessite d'une phase II pour recuperer en sortie les joueurs pour la phase III
        PhaseII phaseII = new PhaseII(themesPhaseII);
        phaseII.getJoueursPhaseII().setParticipants(joueursPhaseII);
        Joueur[] joueursPhaseIII = phaseII.playPhase();

        // On recupere les memes themes (contenant deja les questions) de la phase I pour la phase III
        PhaseIII phaseIII = new PhaseIII(themesPhaseII);
        phaseIII.getJoueursPhaseIII().setParticipants(joueursPhaseIII);
        phaseIII.playPhase();
    }
}
