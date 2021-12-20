/**
 * @author Vanessa MOHAMMEDI
 * @author Kévin HUY
 * @author Thushanthy THEIVENDIRAN
 * @author Lionel NGNINTEDEM
 *
 * Projet Questions Réponses
 *
 * Classe Joueurs : Création de la classe Joueurs composée d'un tableau
 * de Joueur candidats et d'un tableau de Joueur participants
 * Le tableau de Joueur candidats est initialisé à 20
 * Méthode toString + getters et setters des attributs et méthodes
 * de selection de Joueur.
 */

package elements;

public class Joueurs {

    // Tous les personnages du jeu
    private final Joueur[] candidats;
    // Joueurs participants a la partie
    private Joueur[] participants;

    /**
     * Constructeur de Joueurs :
     * Créer un tableau de 20 Joueurs candidats
     * Remplit ce tableau en instanciant un nouveau joueur pour chaque case du tableau
     * Créer le tableau de participants contenant les n partcipants (n choisi par l'utilisateur)
     * @param nbPartipants nombre de joueurs partcipant à la partie
     */
    public Joueurs(int nbPartipants) {
        candidats = new Joueur[20];

        // On remplit le tableau de joueurs candidats
        for(int i=0; i<candidats.length; i++) {
            candidats[i] = new Joueur();
        }
        participants = new Joueur[nbPartipants];
    }

    /**
     * Permet de selectionner aléatoirement un joueur du tableau candidats
     * @return le Joueur selectionné aléatoirement
     */
    public Joueur selectRandomPlayer() {
        Joueur joueur = null;
        while(joueur == null) {
            int indice = (int)(Math.random() * 20);
            joueur = candidats[indice];
            candidats[indice] = null;
        }
        return joueur;
    }

    /**
     * Selectionne aléatoirement l'ensemble des joueurs participants à la partie
     * à l'aide de la methode selectRandomPlayer().
     * Pas de @return car cette méthode permet de remplir le tableau de participants
     * avec les joueurs candidats selectionnés aléatoirement
     */
    public void selectRandomParticipants() {
        for(int i=0; i<participants.length; i++) {
            participants[i] = selectRandomPlayer();
        }
    }

    /**
     * Getter de participants
     * @return l'attribut participants de joueurs
     */
    public Joueur[] getParticipants() {
        return participants;
    }

    /**
     * Setter de participants
     * @param nouveauParticipants tableau de joueur correspondant participants
     * Pas de @return pour un setter, modifie juste l'attribut participants
     */
    public void setParticipants(Joueur[] nouveauParticipants) {
        participants = nouveauParticipants;
    }

    /**
     * Méthode toString
     * @return une représentation textuelle d'un objet joueurs
     */
    @Override
    public String toString() {
        String str = "";
        for(int i=0; i<participants.length; i++) {
            str += participants[i].toString() + '\n';
        }
        return str;
    }
}
