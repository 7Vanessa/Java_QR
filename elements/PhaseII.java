package elements;

import java.util.*;

public class PhaseII implements Phase {

    private final String NOMPHASE = "PhaseII";
    private final Joueurs joueursPhaseII;
    private final Themes themes;

    public PhaseII(Themes themes) {
        this.themes = themes;
        joueursPhaseII = new Joueurs(3);
    }

    @Override
    public Joueurs selectJoueurs() {
        return null;
    }

    @Override
    public Joueur[] playPhase() {
        // Initialisation du nombre de joueurs (elimines compris)
        int nbJoueurs = joueursPhaseII.getParticipants().length;

        // Initialisation des themes de la phase (entre 6 et 20)
        List<Theme> themesPhase = themes.selectNThemes((int) (Math.random() * 15) + 6);

        System.out.println("Thèmes de la phase II :\n" + themesPhase + "\n");
        System.out.println("Chaque joueur va choisir deux thèmes.\n");

        // Remise des etats des gagnant de la phase precedente a "en attente"
        for(Joueur joueur : joueursPhaseII.getParticipants()) {
            if(joueur.getEtat().equals("Gagnant"))
                joueur.updateEtat("a");
        }

        // Choix du nombre de questions par joueurs, entre 2 et 5
        int nbQuestions = (int) (Math.random() * 4) + 2;
        System.out.println("Nombre de questions par joueur : "+nbQuestions);

        Map<String, List<Theme>> themesParticipants = selectionThemeJoueur(themesPhase);

        // Partie de la phase avec DEUX questions moyennes
        int tour = 1;
        questionsDifficulte(tour, themesParticipants);

        // Partie de la phase avec les questions restatnes
        autresQuestions(tour, nbQuestions, themesParticipants);

        System.out.println("Phase II terminée\n");

        // Elimination des joueurs : on enleve les plus faibles
        elimination(nbJoueurs);

        // Affichage du resultat final
        affichagePhase();
        return joueursPhaseII.getParticipants();
    }

    public Map<String, List<Theme>> selectionThemeJoueur(List<Theme> themesPhase) {
        // Initialisation du dictionnaire (cle = nom du joueur encore en lice ; valeur = liste des themes qui lui sont attribues)
        Map<String, List<Theme>> themesParticipants = new HashMap<>();
        for(Joueur joueur : joueursPhaseII.getParticipants()) {
            if(joueur.getEtat().equals("En attente"))
                themesParticipants.put(joueur.getNom(), new ArrayList<>());
        }

        Scanner scanner = new Scanner(System.in);
        String s = "";

        // Ensemble de themes deja pris
        Set<String> setThemesDP = new HashSet<>();

        // Chaque joueur va choisir un theme pendant 2 tours
        for (int i = 0; i < 2; i++) {
            for (Joueur joueur : joueursPhaseII.getParticipants()) {
                if (joueur.getEtat().equals("En attente")) {
                    joueur.updateEtat("s");
                    System.out.println("Joueur " + joueur.getNom() + " : ");
                    boolean found = false;

                    // Tant que le theme entre n'existe pas dans les themes de la phase, on recommence
                    while (!found) {
                        System.out.println("Selectionnez un thème : ");
                        s = scanner.next();

                        // Tant que le theme est deja pris par quelqu'un d'autre, on recommence
                        while (setThemesDP.contains(s)) {
                            System.out.println("Theme non-valide : recommencez");
                            s = scanner.next();
                        }

                        // A ce stade, le theme existe et n'a pas encore ete choisi
                        for (Theme theme : themesPhase) {
                            if (theme.getNom().equals(s)) {
                                found = true;
                                setThemesDP.add(s);
                                themesParticipants.get(joueur.getNom()).add(theme);
                            }
                        }
                    }
                    joueur.updateEtat("a");
                }
            }
        }
        return themesParticipants;
    }

    public void questionsDifficulte(int tour, Map<String, List<Theme>> themesParticipants) {
        int randTheme;
        for (int i = 0; i < 2; i++) {
            System.out.println("Tour " + tour + " :\n");
            tour++;
            for (Joueur joueur : joueursPhaseII.getParticipants()) {

                // Indice de l'un des deux themes du joueur
                randTheme = (int) (Math.random()*2);
                if (!joueur.getEtat().equals("Eliminé")) {
                    joueur.updateEtat("s");
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                    Question randQuestion = themesParticipants.get(joueur.getNom()).get(randTheme).getQuestions().selectRandQuestion();

                    // On veut des questions de difficulte "moyen"
                    while (randQuestion.getDifficulte() != 2) {
                        randQuestion = themesParticipants.get(joueur.getNom()).get(randTheme).getQuestions().selectRandQuestion();
                    }

                    System.out.println(randQuestion);
                    try {
                        randQuestion.testBonneReponse(joueur, NOMPHASE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    joueur.updateEtat("a");
                }
            }
        }
    }

    public void autresQuestions(int tour, int nbQuestions, Map<String, List<Theme>> themesParticipants) {
        // -2 a cause des deux premiers tours avec les deux questions moyennes
        for (int k = 0; k < nbQuestions-2; k++) {
            int randTheme;
            System.out.println("Tour " + tour + " :\n");
            tour++;
            for (Joueur joueur : joueursPhaseII.getParticipants()) {

                // Indice de l'un des deux themes du joueur
                randTheme = (int) (Math.random()*2);
                if (!(joueur.getEtat().equals("Eliminé"))) {
                    joueur.updateEtat("s");
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());

                    // On pose au joueur du question du theme de la phase de cet indice
                    Question randQuestion = themesParticipants.get(joueur.getNom()).get(randTheme).getQuestions().selectRandQuestion();
                    System.out.println(randQuestion);
                    try {
                        randQuestion.testBonneReponse(joueur, NOMPHASE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    joueur.updateEtat("a");
                }
            }
        }
    }

    @Override
    public void elimination(int nbJoueurs) {
        int nbFinalistes = 0;
        for(Joueur joueur : joueursPhaseII.getParticipants()) {
            if(!joueur.getEtat().equals("Eliminé"))
                nbFinalistes++;
        }

        // Algotithme pour trouver le minimum d'un tableau
        // Tant qu'on a pas de finalistes
        while (nbFinalistes > 2) {
            int k = 0;
            int min;

            // On initialise "min" avec le score du premier joueur non-elimine
            do {
                min = joueursPhaseII.getParticipants()[k].getScore();
                k++;
            } while(joueursPhaseII.getParticipants()[k-1].getEtat().equals("Eliminé"));

            // Indice du joueur avec le plus bas score
            int indiceMin = k-1;
            for (int i = 0; i < nbJoueurs; i++) {

                // Si le joueur courant a un score plus petit que "min" ET si ce joueur n'est pas deja elimine
                if (joueursPhaseII.getParticipants()[i].getScore() < min && !joueursPhaseII.getParticipants()[i].getEtat().equals("Eliminé")) {
                    min = joueursPhaseII.getParticipants()[i].getScore();
                    indiceMin = i;
                }
            }

            // On elimine le joueur a l'indice du joueur avec le plus bas score
            joueursPhaseII.getParticipants()[indiceMin].updateEtat("e");
            nbFinalistes--;
        }
    }

    @Override
    public void affichagePhase() {
        System.out.println("Joueurs encore en lice : ");

        // Pour chaque joueur de la phase...
        for (Joueur joueur : joueursPhaseII.getParticipants()) {

            // ...si il n'est pas elimine...
            if(!joueur.getEtat().equals("Eliminé"))
                // ...on met le statur a "Gagnant"
                joueur.updateEtat("g");
            System.out.println(joueur);
        }
    }

    public Joueurs getJoueursPhaseII() {
        return joueursPhaseII;
    }
}
