package elements;

public class Joueurs {

    private Joueur[] candidats;
    private Joueur[] participants;

    public Joueurs(int nbPartipants) {
        candidats = new Joueur[20];
        // On remplit le tableau de joueurs candidats
        for(int i=0; i<candidats.length; i++) {
            candidats[i] = new Joueur();
        }
        participants = new Joueur[nbPartipants];
    }

    public Joueur[] getParticipants() {
        return participants;
    }

    public Joueur selectRandomPlayer() {
        Joueur joueur = null;
        while(joueur == null) {
            int indice = (int)(Math.random() * 20);
            joueur = candidats[indice];
            candidats[indice] = null;
        }
        return joueur;
    }

    public void selectRandomParticipants() {
        for(int i=0; i<participants.length; i++) {
            participants[i] = selectRandomPlayer();
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0; i<participants.length; i++) {
            str += participants[i].toString() + '\n';
        }
        return str;
    }
}
