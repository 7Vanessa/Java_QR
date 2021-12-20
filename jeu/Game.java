package jeu;

import elements.*;

import java.util.Scanner;

public class Game {
    public static void main(String []args) {
        boolean play = true;
        while(play) {
            // Phase I
            PhaseI phaseI = new PhaseI();
            Joueur[] joueursPhaseII = phaseI.playPhase();

            // Phase II
            Themes themesPhaseII = phaseI.getThemes();
            PhaseII phaseII = new PhaseII(themesPhaseII);
            phaseII.getJoueursPhaseII().setParticipants(joueursPhaseII);
            Joueur[] joueursPhaseIII = phaseII.playPhase();

            // Phase III
            PhaseIII phaseIII = new PhaseIII(themesPhaseII);
            phaseIII.getJoueursPhaseIII().setParticipants(joueursPhaseIII);
            phaseIII.playPhase();

            // Rejouer ?
            Scanner scanner = new Scanner(System.in);
            String s;
            do {
                System.out.println("Souhaitez vous rejouer ? (oui/non): ");
                s = scanner.next();
                s.toLowerCase();
            } while(!s.equals("oui") && !s.equals("non"));
            if(s.equals("non"))
                play = false;
        }
    }
}
