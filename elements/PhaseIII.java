package elements;

import java.util.*;

public class PhaseIII implements Phase {

    private final String NOMPHASE = "PhaseIII";
    private Joueurs joueursPhaseIII;
    private Themes themes;

    public PhaseIII(Themes themes) {
        this.themes = themes;
        joueursPhaseIII = new Joueurs(3);
    }

    @Override
    public Joueurs selectJoueurs() {
        return null;
    }

    @Override
    public Joueur[] playPhase() {
        int nbJoueurs = joueursPhaseIII.getParticipants().length;
        Scanner scanner = new Scanner(System.in);

        for(Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(joueur.getEtat().equals("Gagnant"))
                joueur.updateEtat("a");
        }

        // 2)
        List<Theme> listThemesPhase = new ArrayList<>();

        // Themes choisis par le concepteur du jeu
        for(Theme theme : themes.getThemes()) {
            if(theme.getNom().equals("pokemon") || theme.getNom().equals("corps_humain") || theme.getNom().equals("super_heros"))
                listThemesPhase.add(theme);
        }

        System.out.println("\nThèmes de la phase III :\n" + listThemesPhase + "\n");
        System.out.println("Chaque joueur va choisir deux thèmes.\n");


        // 4)
        int nbQuestions = (int) (Math.random() * 4) + 2;
        System.out.println("Nombre de questions par joueur : "+nbQuestions);

        // Selection aleatoire d'un theme parmis ces n themes
        int indiceTheme = (int) (Math.random() * listThemesPhase.size());
        Theme unTheme = listThemesPhase.get(indiceTheme);

        // 5) Questions posees aux joueurs
        int tour = 1;

        // a) round avec minimum 2 questions difficiles
        for (int i = 0; i < 2; i++) {
            System.out.println("Tour " + tour + " : " + unTheme + "\n");
            tour++;
            for (Joueur joueur : joueursPhaseIII.getParticipants()) {
                if (!joueur.getEtat().equals("Eliminé")) {
                    System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                    joueur.updateEtat("s");
                    Question randQuestion = unTheme.getQuestions().selectRandQuestion();

                    //on veut des questions de difficulte 3
                    while (randQuestion.getDifficulte() != 3) {
                        randQuestion = unTheme.getQuestions().selectRandQuestion();
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
            indiceTheme++;
            if(indiceTheme >= listThemesPhase.size())
                indiceTheme = 0;
            unTheme = listThemesPhase.get(indiceTheme);
        }

        // b) round avec le nombre de questions restant
        // for(int j = 0 ; j < nbQuestions-1 ; j++) { // -1 a cause du premier tour avec questions faciles

        int j = -1;
        indiceTheme--;

        for (int k = 0; k < listThemesPhase.size(); k++) { // nombre de questions, -2 a cause des premiers tours avec questions difficiles
            j++;
            if(j < nbQuestions-2) { // nombre de themes au total
                indiceTheme++;
                if(indiceTheme >= listThemesPhase.size())
                    indiceTheme = 0;
                unTheme = listThemesPhase.get(indiceTheme);
                System.out.println("Tour " + tour + " : " + unTheme + "\n");
                tour++;
                for (Joueur joueur : joueursPhaseIII.getParticipants()) {
                    if (!joueur.getEtat().equals("Eliminé")) {
                        System.out.println("Joueur " + joueur.getNom() + " n°" + joueur.getNumero());
                        joueur.updateEtat("s");
                        Question randQuestion = unTheme.getQuestions().selectRandQuestion();
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
            else
                break;
        }

        System.out.println("Phase III terminée\n");

        // 6) elimination des joueurs : on enleve les plus faibles
        int vainqueur = 0;
        for(Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(!joueur.getEtat().equals("Eliminé"))
                vainqueur++;
        }
        while (vainqueur > 1) {
            int k = 0;
            int min;
            do {
                min = joueursPhaseIII.getParticipants()[k].getScore();
                k++;
            } while(joueursPhaseIII.getParticipants()[k-1].getEtat().equals("Eliminé"));
            int indiceMin = k-1;
            for (int i = 0; i < nbJoueurs; i++) {
                if (joueursPhaseIII.getParticipants()[i].getScore() < min && !joueursPhaseIII.getParticipants()[i].getEtat().equals("Eliminé")) {
                    min = joueursPhaseIII.getParticipants()[i].getScore();
                    indiceMin = i;
                }
            }
            if(!joueursPhaseIII.getParticipants()[indiceMin].getEtat().equals("Eliminé")) {
                joueursPhaseIII.getParticipants()[indiceMin].updateEtat("e");
                vainqueur--;
            }
        }

        System.out.println("Résultat final : ");
        for (Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(!joueur.getEtat().equals("Eliminé"))
                joueur.updateEtat("sg");
            System.out.println(joueur);
        }

        for(Joueur joueur : joueursPhaseIII.getParticipants()) {
            if(joueur.getEtat().equals("Super Gagnant"))
                System.out.println("Le grand gagnant est : " + joueur.getNom() + " n°" + joueur.getNumero());
        }
        return joueursPhaseIII.getParticipants();
    }

    @Override
    public String getNomPhase() {
        return NOMPHASE;
    }

    public Joueurs getJoueursPhaseIII() {
        return joueursPhaseIII;
    }
}
