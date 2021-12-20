package elements;

import java.util.*;

public class PhaseIII implements Phase {

    private final String NOMPHASE = "PhaseIII";
    private final Joueurs joueursPhaseIII;
    private final Themes themes;

    public PhaseIII(Themes themes) {
        this.themes = themes;
        joueursPhaseIII = new Joueurs(2);
    }

    // Pas d'utilite dans cette phase
    @Override
    public Joueurs selectJoueurs() {
        return null;
    }

    /**
     * Lancement de la phase III
     * @return l'etat des joueurs
     */
    @Override
    public Joueur[] playPhase() {
        // Initialisation du nombre de joueurs (elimines compris)
        int nbJoueurs = joueursPhaseIII.getParticipants().length;

        // Themes choisis par le concepteur du jeu
        List<Theme> themesPhase = new ArrayList<>();
        for(Theme theme : themes.getThemes()) {
            if(theme.getNom().equals("pokemon") || theme.getNom().equals("corps_humain") || theme.getNom().equals("super_heros")) {
                themesPhase.add(theme);
            }
        }

        System.out.println("\nThèmes de la phase III :\n" + themesPhase + "\n");
        System.out.println("Chaque joueur va choisir deux thèmes.\n");

        // Remise des etats des gagnant de la phase precedente a "en attente"
        for(Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(joueur.getEtat().equals("Gagnant")) {
                joueur.updateEtat("a");
            }
        }

        // // Choix du nombre de questions par joueurs, entre 2 et 5
        int nbQuestions = (int) (Math.random() * 4) + 2;
        System.out.println("Nombre de questions par joueur : "+nbQuestions);

        // Selection aleatoire d'un theme parmis ces n themes
        int indiceTheme = (int) (Math.random() * themesPhase.size());
        Theme unTheme = themesPhase.get(indiceTheme);

        // Question choisie au hasard pour le premier joueur du 1er tour
        int indiceQuestion = unTheme.getQuestions().indiceRandQuestions();

        // Partie de la phase avec deux questions difficiles
        int tour = 1;
        indiceQuestion = questionsDifficulte(tour, indiceTheme, unTheme, themesPhase, indiceQuestion);

        // Parties de la phase avec les questions restantes
        autresQuestions(tour, nbQuestions, indiceTheme, themesPhase, indiceQuestion);

        System.out.println("Phase III terminée\n");

        // Elimination des joueurs : on enleve les plus faibles
        elimination(nbJoueurs);

        // Affichage du resultat final
        affichagePhase();

        return joueursPhaseIII.getParticipants();
    }

    /**
     * Correspond a la partie de la phase avec au moins un question facile
     * @param tour correspond au n-ieme tour de la phase
     * @param indiceTheme correspond a l'indice du theme du tour actuel
     * @param theme correspond a l'indice du theme choisi a chaque tour
     * @param themesPhase correspond aux themes de la phase
     * @return le tour pour les questions restantes
     */
    public int questionsDifficulte(int tour, int indiceTheme, Theme theme, List<Theme> themesPhase, int indiceQuestion) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Tour " + tour + " : " + theme + "\n");
            tour++;

            // Round-Robin
            for (Joueur joueur : joueursPhaseIII.getParticipants()) {
                if (!joueur.getEtat().equals("Eliminé")) {
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                    joueur.updateEtat("s");
                    Question question = theme.getQuestions().selectRandQuestion();

                    //on veut des questions de difficulte "difficile"
                    if(joueur.getNom().equals(joueursPhaseIII.getParticipants()[0].getNom()) && tour == 1) {
                        System.out.println(question);
                        try {
                            question.testBonneReponse(joueur, NOMPHASE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    // Sinon, politique de Round-Robin
                    else {
                        do {
                            indiceQuestion++;
                            if(indiceQuestion >= theme.getQuestions().getQuestions().size())
                                indiceQuestion = 0;
                            question = theme.getQuestions().getQuestions().get(indiceQuestion);
                        } while(theme.getQuestions().getQuestions().get(indiceQuestion).getDifficulte() != 1);

                        System.out.println(question);
                        try {
                            question.testBonneReponse(joueur, NOMPHASE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    joueur.updateEtat("a");
                }
            }
            indiceTheme++;
            if(indiceTheme >= themesPhase.size())
                indiceTheme = 0;
            theme = themesPhase.get(indiceTheme);
        }
        return indiceQuestion;
    }

    /**
     * Correspond a la partie de la phase avec le reste des questions
     * @param tour correspond au n-ieme tour de la phase
     * @param nbQuestions correspond au nombre de questions restant
     * @param indiceTheme correspond a l'indice du theme choisi a chaque tour
     * @param themesPhase correspond aux themes de la phase
     */
    public void autresQuestions(int tour, int nbQuestions, int indiceTheme, List<Theme> themesPhase, int indiceQuestion) {
        int j = -1;

        // tour += 2 a cause des deux premiers tours avec les questions difficiles
        tour += 2;

        // On decremente "indiceTheme" car il y aurait un decalage lors de la premiere iteration avec l'incrementation a la ligne 117
        indiceTheme--;

        for (int k = 0; k < themesPhase.size(); k++) {
            j++;

            // -2 a cause des premiers tours avec les deux questions difficiles
            if(j < nbQuestions-2) {
                indiceTheme++;
                if(indiceTheme >= themesPhase.size())
                    indiceTheme = 0;

                // On recupere le theme de la phase a cet indice
                Theme theme = themesPhase.get(indiceTheme);

                // Continuite du Round-Robin
                Question question = theme.getQuestions().getQuestions().get(indiceQuestion);

                System.out.println("Tour " + tour + " : " + theme + "\n");
                tour++;

                // Pour chaque joueur... (Round-Robin)
                for (Joueur joueur : joueursPhaseIII.getParticipants()) {
                    if (!joueur.getEtat().equals("Eliminé")) {
                        System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                        joueur.updateEtat("s");

                        // ...on lui pose du question du theme de la phase de cet indice
                        indiceQuestion++;
                        if(indiceQuestion >= theme.getQuestions().getQuestions().size())
                            indiceQuestion = 0;

                        System.out.println(question);
                        try {
                            question.testBonneReponse(joueur, NOMPHASE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        joueur.updateEtat("a");
                    }
                }
            }
            else
                break;
        }

    }

    /**
     * Correspond a la partie de la phase avec l'elimination des perdants
     * @param nbJoueurs correspond au nombre de joueurs
     */
    @Override
    public void elimination(int nbJoueurs) {
        int vainqueur = 0;
        for(Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(!joueur.getEtat().equals("Eliminé"))
                vainqueur++;
        }

        // Algotithme pour trouver le minimum d'un tableau
        // Tant qu'on a pas de vainqueur
        while (vainqueur > 1) {
            int k = 0;
            int min;

            // On initialise "min" avec le score du premier joueur non-elimine
            do {
                min = joueursPhaseIII.getParticipants()[k].getScore();
                k++;
            } while(joueursPhaseIII.getParticipants()[k-1].getEtat().equals("Eliminé"));

            // Indice du joueur avec le plus bas score
            int indiceMin = k-1;
            for (int i = 0; i < nbJoueurs; i++) {

                // Si le joueur courant a un score plus petit que "min" ET si ce joueur n'est pas deja elimine
                if (joueursPhaseIII.getParticipants()[i].getScore() < min && !joueursPhaseIII.getParticipants()[i].getEtat().equals("Eliminé")) {
                    min = joueursPhaseIII.getParticipants()[i].getScore();
                    indiceMin = i;
                }
            }

            // On elimine le joueur a l'indice du joueur avec le plus bas score
            if(!joueursPhaseIII.getParticipants()[indiceMin].getEtat().equals("Eliminé")) {
                joueursPhaseIII.getParticipants()[indiceMin].updateEtat("e");
                vainqueur--;
            }
        }
    }

    /**
     * Correspond a l'affichage du resultat final de la phase, avec le grand vainqueur
     */
    @Override
    public void affichagePhase() {
        System.out.println("Résultat final : ");

        // Pour chaque joueur de la phase...
        for (Joueur joueur : joueursPhaseIII.getParticipants()) {

            // ...si il n'est pas elimine...
            if(!joueur.getEtat().equals("Eliminé"))

                // ...on met le statur a "Super Gagnant"
                joueur.updateEtat("sg");
            System.out.println(joueur);
        }

        // Affichage du grand gagnat
        for(Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(joueur.getEtat().equals("Super Gagnant"))
                System.out.println("Le grand gagnant est : " + joueur.getNom() + " n°" + joueur.getNumero());
        }
    }

    // Getter
    public Joueurs getJoueursPhaseIII() {
        return joueursPhaseIII;
    }
}
