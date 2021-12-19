package elements;

import java.util.*;

public class PhaseII implements Phase {

    private final String NOMPHASE = "PhaseII";
    private Joueurs joueursPhaseII;
    private Themes themes;

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
        int nbJoueurs = joueursPhaseII.getParticipants().length;
        Scanner scanner = new Scanner(System.in);

        // 2)
        List<Theme> listThemesPhase = themes.selectNThemes((int) (Math.random() * 15) + 6);

        System.out.println("Thèmes de la phase II :\n" + listThemesPhase + "\n");
        System.out.println("Chaque joueur va choisir deux thèmes.\n");

        for(Joueur joueur : joueursPhaseII.getParticipants()) {
            if(joueur.getEtat().equals("Gagnant"))
                joueur.updateEtat("a");
        }

        // liste : j1,j2,j3,j1,j2,j3
        Map<String, List<Theme>> themesParticipants = new HashMap<>();
        for(Joueur joueur : joueursPhaseII.getParticipants()) {
            if(joueur.getEtat().equals("En attente"))
                themesParticipants.put(joueur.getNom(), new ArrayList<>());
        }

        String s = "";
        Set<String> setThemesDP = new HashSet<>();

        for (int i = 0; i < 2; i++) {
            for (Joueur joueur : joueursPhaseII.getParticipants()) {
                if (joueur.getEtat().equals("En attente")) {
                    joueur.updateEtat("s");
                    System.out.println("Joueur " + joueur.getNom() + " : ");
                    boolean found = false;
                    while(!found) {
                        System.out.println("Selectionnez un thème : ");
                        s = scanner.next();
                        while (setThemesDP.contains(s)) {
                            System.out.println("Theme non-valide : recommencez");
                            s = scanner.next();
                        }
                        for (Theme theme : listThemesPhase) {
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

        System.out.println(themesParticipants);

        // 4)
        int nbQuestions = (int) (Math.random() * 4) + 2;
        System.out.println("Nombre de questions par joueur : "+nbQuestions);

        // 5) Questions posees aux joueurs
        int tour = 1;

        // a) round avec minimum 2 questions moyennes

        int randTheme;

        // 2 questions moyennes
        for (int i = 0; i < 2; i++) {
            System.out.println("Tour " + tour + " :\n");
            tour++;
            for (Joueur joueur : joueursPhaseII.getParticipants()) {
                randTheme = (int) (Math.random()*2);
                if (!joueur.getEtat().equals("Eliminé")) {
                    joueur.updateEtat("s");
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                    Question randQuestion = themesParticipants.get(joueur.getNom()).get(randTheme).getQuestions().selectRandQuestion();

                    //on veut des questions de difficulte 2
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

        // b) round avec le nombre de questions restant
        for (int k = 0; k < nbQuestions-2; k++) {  // -2 a cause des deux premiers tours avec questions moyennes
            System.out.println("Tour " + tour + " :\n");
            tour++;
            for (Joueur joueur : joueursPhaseII.getParticipants()) {
                randTheme = (int) (Math.random()*2);
                if (!(joueur.getEtat().equals("Eliminé"))) {
                    joueur.updateEtat("s");
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
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

        System.out.println("Phase II terminée\n");

        // 6) elimination des joueurs : on enleve les plus faibles
        int nbFinalistes = 0;
        for(Joueur joueur : joueursPhaseII.getParticipants()) {
            if(!joueur.getEtat().equals("Eliminé"))
                nbFinalistes++;
        }
        while (nbFinalistes > 2) {
            int k = 0;
            int min;
            do {
                min = joueursPhaseII.getParticipants()[k].getScore();
                k++;
            } while(joueursPhaseII.getParticipants()[k-1].getEtat().equals("Eliminé"));
            int indiceMin = k-1;
            for (int i = 0; i < nbJoueurs; i++) {
                if (joueursPhaseII.getParticipants()[i].getScore() < min && !joueursPhaseII.getParticipants()[i].getEtat().equals("Eliminé")) {
                    min = joueursPhaseII.getParticipants()[i].getScore();
                    indiceMin = i;
                }
            }
            if(!joueursPhaseII.getParticipants()[indiceMin].getEtat().equals("Eliminé")) {
                joueursPhaseII.getParticipants()[indiceMin].updateEtat("e");
                nbFinalistes--;
            }
        }

        System.out.println("Joueurs encore en lice : ");
        for (Joueur joueur : joueursPhaseII.getParticipants()) {
            if(!joueur.getEtat().equals("Eliminé"))
                joueur.updateEtat("g");
            System.out.println(joueur);
        }
        return joueursPhaseII.getParticipants();
    }

    @Override
    public String getNomPhase() {
        return NOMPHASE;
    }

    public Joueurs getJoueursPhaseII() {
        return joueursPhaseII;
    }
}
