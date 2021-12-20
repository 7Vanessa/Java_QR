package elements;

public class Joueurs {

    private final Joueur[] candidats;
    private Joueur[] participants;

    public Joueurs(int nbPartipants) {
        candidats = new Joueur[20];

        // On remplit le tableau de joueurs candidats
        for(int i=0; i<candidats.length; i++) {
            candidats[i] = new Joueur();
        }
        participants = new Joueur[nbPartipants];
    }

    // Selection au hasard du personnage du joueur
    public Joueur selectRandomPlayer() {
        Joueur joueur = null;
        while(joueur == null) {
            int indice = (int)(Math.random() * 20);
            joueur = candidats[indice];
            candidats[indice] = null;
        }
        return joueur;
    }

    // Selection au hasard des joueurs de la partie
    public void selectRandomParticipants() {
        for(int i=0; i<participants.length; i++) {
            participants[i] = selectRandomPlayer();
        }
    }

    // Getter
    public Joueur[] getParticipants() {
        return participants;
    }

    // Setter
    public void setParticipants(Joueur[] nouveauParticipants) {
        participants = nouveauParticipants;
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
