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

        // liste : j1,j2,j3,j1,j2,j3

        String s = "";
        Set<String> setThemesDP = new HashSet<>();
        Map<String, List<Theme>> themesParticipants = new HashMap<>();
        List<Theme> j1 = new ArrayList<>();
        List<Theme> j2 = new ArrayList<>();
        List<Theme> j3 = new ArrayList<>();

        System.out.println(Arrays.toString(joueursPhaseII.getParticipants()));

        int compteur = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j<joueursPhaseII.getParticipants().length ; j++) {
                if (joueursPhaseII.getParticipants()[j].getEtat().equals("Sélectionné")) {
                    System.out.println("Joueur " + joueursPhaseII.getParticipants()[j].getNom() + " : ");
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
                                switch(compteur) {
                                    case 0 -> j1.add(theme);
                                    case 1 -> j2.add(theme);
                                    case 2 -> j3.add(theme);
                                }
                                if(i == 1) {
                                    switch (compteur) {
                                        case 0 -> themesParticipants.put(joueursPhaseII.getParticipants()[j].getNom(), j1);
                                        case 1 -> themesParticipants.put(joueursPhaseII.getParticipants()[j].getNom(), j2);
                                        case 2 -> themesParticipants.put(joueursPhaseII.getParticipants()[j].getNom(), j3);
                                    }
                                }
                            }
                        }
                    }
                    compteur++;
                }
            }
        }

        System.out.println(themesParticipants);
        System.out.println(j3);

        // 4)
        int nbQuestions = (int) (Math.random() * 3) + 2;
        //System.out.println("Nombre de questions par joueur : "+nbQuestions);
        System.out.println("\nNombre de questions par joueur : 2");

        // 5) Questions posees aux joueurs
        int tour = 1;

        // a) round avec minimum 2 questions moyennes
        System.out.println("Tour " + tour + " :\n");
        tour++;

        int mini = 0;
        int maxi = 3;
        int randTheme = (int) (Math.random()*2);

        for (int i = 0; i < 2; i++) {
            for (Joueur joueur : joueursPhaseII.getParticipants()) {
                if (!(joueur.getEtat().equals("Eliminé"))) {
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
                }
            }
        }

        // b) round avec le nombre de questions restant
        // for(int j = 0 ; j < nbQuestions-1 ; j++) { // -1 a cause du premier tour avec questions faciles

        //while(j < nbQuestions-2) {
        // for(int k = 0 ; k < nbQuestions-2 ; k++ ) // -2 a cause du premier tour avec questions moyennes
        for (int k = 0; k < 2; k++) {
            System.out.println("Tour " + tour + " :\n");
            tour++;
            for (Joueur joueur : joueursPhaseII.getParticipants()) {
                if (!(joueur.getEtat().equals("Eliminé"))) {
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                    Question randQuestion = themesParticipants.get(joueur.getNom()).get(randTheme).getQuestions().selectRandQuestion();
                    System.out.println(randQuestion);
                    try {
                        randQuestion.testBonneReponse(joueur, NOMPHASE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
        System.out.println(nbFinalistes);
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
